package com.android.main

import android.app.Application
import com.llj.baselib.IOTLib
import com.llj.baselib.bean.UserConfigBean

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val bean = UserConfigBean(
            userId = "19199",
            appKey = "f7262b6319",
            deviceId = "25845",
            clientId = "1209",
            clientSecret = "dc30d89247"
        )
        IOTLib.init(applicationContext,bean)
    }
}