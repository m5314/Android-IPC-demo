package com.example.moj.localCSFramework

/**
 * 若线程内需要死循环逻辑，可使用mRunning变量控制终止循环
 * Created by moj on 2018/8/8.
 */
open class MyRunnable : Runnable {
    constructor()

    override fun run() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
//    constructor(target: Runnable?) : super(target)

    var mRunning:Boolean = true


}