package com.examle.api.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager


object NetworkUtil {

    @JvmStatic
    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null
    }
}