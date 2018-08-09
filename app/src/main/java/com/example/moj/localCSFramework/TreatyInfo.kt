package com.example.moj.localCSFramework

import android.os.Bundle
import android.os.Messenger

/**
 * 指令集，注册相关协议
 * Created by moj on 2018/8/8.
 */
class TreatyInfo {

    companion object {
        //一号测试协议
        val ID_TEST = 0x1

        val mMap = HashMap<Int,IProcessor>()
        init {
            mMap.put(ID_TEST,TestProcessor())
        }

        fun getResult(m:Messenger,b:Bundle){
            val p:IProcessor?= mMap[b.getInt("id")]
            p?.serverHandle(b,m)
        }

        fun handleResult(id:Int,b:Bundle){
            val p:IProcessor?= mMap[id]
            p?.clientHandle(b)
        }
    }


}