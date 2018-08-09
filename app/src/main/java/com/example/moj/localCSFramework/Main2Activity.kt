package com.example.moj.localCSFramework

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Main2Activity : AppCompatActivity() {
//    var mConnectionHelper:ConnectionHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = Intent(this,MyService::class.java)
//        mConnectionHelper = ConnectionHelper(this,intent)

    }

    override fun onDestroy() {
        super.onDestroy()
//        mConnectionHelper?.destroy()
    }

    fun getResult(v: View){
        val b = Bundle()
        b.putInt("id",TreatyInfo.ID_TEST)
        b.putString("testInfo","hello world")
        ConnectionHelper.sendMessage(b)
    }


}
