package com.example.moj.localCSFramework

import android.app.Application

/**
 * Created by moj on 2018/8/8.
 */
class AppContext : Application() {

    companion object {
        var mInstance:AppContext?=null
        fun getInstance():AppContext?{
            return mInstance
        }
    }

    override fun onCreate() {
        mInstance = this
        super.onCreate()
    }
}