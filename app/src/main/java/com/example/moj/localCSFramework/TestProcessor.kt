package com.example.moj.localCSFramework

import android.os.Bundle
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import android.util.Log
import org.greenrobot.eventbus.EventBus

/**
 * Created by moj on 2018/8/8.
 */
class TestProcessor : IProcessor {

    /**
     * CMD : 0X1
     * client -> server
     * Params {
     *      testInfo : String 测试信息
     *      }
     *
     * server -> client
     * Params {
     *       result : String 运算结果
     *      }
     */
    override fun serverHandle(bundle: Bundle, m: Messenger) {
        Thread(Runnable {
            Thread.sleep(5000)
            //Messenger传递的是Message，所以新建一个Message实例
            val msgFromService = Message.obtain(null, MyServiceHandler.MSG_FROM_SERVICE)
            //设置对应id号，用来识别回复的哪一个协议
            msgFromService.arg1 = TreatyInfo.ID_TEST
            val str = bundle["testInfo"]?:""
            Log.i("asd","recrive msg : "+str)
            val b = Bundle()
            b.putString("result","sccess")
            msgFromService.data = b
            try {
                //调用mClientMessenger.send将消息发送给客户端
                m.send(msgFromService)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }).start()

    }

    override fun clientHandle(bundle: Bundle) {
        EventBus.getDefault().post(TestEB(bundle))
    }
}