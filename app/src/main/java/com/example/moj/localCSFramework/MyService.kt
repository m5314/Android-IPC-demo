package com.example.moj.localCSFramework

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Messenger

/**
 * 远程服务器
 */
class MyService : Service() {

    private val mHandler:MyServiceHandler = MyServiceHandler()

    private var mMessenger:Messenger? = Messenger(mHandler)

    override fun onBind(intent: Intent): IBinder? {
        return mMessenger?.binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}
