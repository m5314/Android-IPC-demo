package com.example.moj.localCSFramework

import android.os.Bundle

/**
 * Created by moj on 2018/8/8.
 */
open class BaseEB {
    constructor(data: Bundle?) {
        this.data = data
    }

    var data:Bundle?=null
}