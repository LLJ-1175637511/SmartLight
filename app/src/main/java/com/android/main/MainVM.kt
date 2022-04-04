package com.android.main

import com.llj.baselib.IOTViewModel

class MainVM : IOTViewModel() {

    fun openLight() {
        sendOrderToDevice("A")
    }

    fun closeLight() {
        sendOrderToDevice("B")
    }

    fun scrollLight(num: Int) {
        sendOrderToDevice("E:${num}")
    }

    fun openWindow() {
        sendOrderToDevice("C")
    }

    fun closeWindow() {
        sendOrderToDevice("D")
    }

    fun closeAllLight() {
        sendOrderToDevice("F")
    }


}