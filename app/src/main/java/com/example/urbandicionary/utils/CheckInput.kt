package com.example.urbandicionary.utils

import android.content.Context

class CheckInput(val context: Context) {
    companion object Factory {
        fun isValidInput(name: String?): Boolean {
            return name!!.matches("[a-zA-Z]+".toRegex())
        }
    }
}

