package com.example.moj.localCSFramework

import android.os.Bundle
import android.os.Messenger

/**
 * 指令处理器接口
 * Created by moj on 2018/8/8.
 */
interface IProcessor {
    fun serverHandle(bundle: Bundle, m: Messenger)
    fun clientHandle(bundle: Bundle)
}