package com.example.moj.localCSFramework

import android.annotation.SuppressLint
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import com.example.moj.localCSFramework.MyServiceHandler.Companion.MSG_FROM_CLIENT
import com.example.moj.localCSFramework.MyServiceHandler.Companion.MSG_FROM_SERVICE
import android.os.Bundle
import android.os.Messenger
import android.os.IBinder
import android.content.ComponentName
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent


/**
 * 用于管理服务器连接、操作
 * Created by moj on 2018/8/8.
 */
class ConnectionHelper {
    private var conn: ServiceConnection? = null
    private var mClientMessenger: Messenger? = null
    private var mServiceMessenger: Messenger? = null
    private var mCache:ArrayList<Bundle> = ArrayList()
//    private var mRunning = true
    private var mRunnable:MyRunnable?=null

    private var mClientHandler = @SuppressLint("HandlerLeak")

    object : Handler() {
        override fun handleMessage(msgFromService: Message) {
            when (msgFromService.what) {
                MSG_FROM_SERVICE -> {
                    Log.i("receive","" + msgFromService.data["result"])
                    TreatyInfo.handleResult(msgFromService.arg1,msgFromService.data)

                }
            }
        }
    }

    companion object {
        private var instance:ConnectionHelper?=null
        fun getInstances():ConnectionHelper?{
            if(instance == null){
                instance = ConnectionHelper()
            }
            return instance
        }

        fun sendMessage(data:Bundle){
            getInstances()?.sendMessage(data)
        }
    }

    init {
        mClientMessenger = Messenger(mClientHandler)
        conn = object : ServiceConnection {


            override fun onServiceDisconnected(name: ComponentName) {
                Log.i("asd","onServiceDisconnected")
                //崩溃重连
                connect()
            }

            override fun onServiceConnected(name: ComponentName, iBinder: IBinder) {
                //拿到服务器传给客户端的IBinder，通过new Messenger(service)拿到mServiceMessenger
                mServiceMessenger = Messenger(iBinder)
            }
        }
        connect()
    }

    @Synchronized fun sendMessage(data: Bundle){
//        if()
        if(mCache.contains(data)){
            //防重复请求
            return
        }
        mCache.add(data)
    }

    private fun connect(){
        mRunnable?.mRunning = false
        AppContext.mInstance?.bindService(Intent(AppContext.mInstance,MyService::class.java),conn,BIND_AUTO_CREATE)
        mRunnable = object : MyRunnable() {
            override fun run() {
                try {
                    while (mRunning) {
                        if (mCache.isEmpty()) {
                            Thread.sleep(50)
                        } else {
                            val b = mCache.removeAt(0)
                            val msg: Message = Message.obtain(null, MSG_FROM_CLIENT)
                            msg.data = b
                            msg.replyTo = mClientMessenger
                            mServiceMessenger?.send(msg)
                        }
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        Thread(mRunnable).start()
    }
}