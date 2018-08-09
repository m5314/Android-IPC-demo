package com.example.moj.localCSFramework

import android.os.*
import android.util.Log


/**
 * 服务器Handler,接收客户端指令做相应处理
 * Created by moj on 2018/8/8.
 */
class MyServiceHandler: Handler() {
    companion object {
        val MSG_FROM_CLIENT = 0
        val MSG_FROM_SERVICE = 1
    }

    override fun handleMessage(msg: Message?) {
        Log.i("asd","cmd : " + msg )
        when (msg?.what) {
            MSG_FROM_CLIENT -> {
                deal(msg)

            }
        }
    }

    fun deal(msg:Message){
        //拿到客户端的mClientMessenger
        val mClientMessenger = msg.replyTo
        //根据协议号进行相关处理
        TreatyInfo.getResult(mClientMessenger,msg.data)

    }
}