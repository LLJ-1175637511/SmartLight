package com.android.main

import com.llj.baselib.IOTViewModel

class MainVM : IOTViewModel() {

    fun openLight() {
        sendOrderToDevice("A")
    }

    fun closeLight() {
        sendOrderToDevice("A")
    }

    fun scrollLight(num: Int) {
        sendOrderToDevice(num.toString())
    }

    fun openWindow() {
        sendOrderToDevice("A")
    }

    fun closeWindow() {
        sendOrderToDevice("A")
    }

    fun closeAllLight() {
        sendOrderToDevice("A")
    }


}