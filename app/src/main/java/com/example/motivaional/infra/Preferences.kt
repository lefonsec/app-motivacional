package com.example.motivaional.infra

import android.content.Context
import android.content.SharedPreferences
import java.security.AccessControlContext

class Preferences(context: Context) {

    private val security: SharedPreferences =
        context.applicationContext.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String,str: String){
        security.edit().putString(key,str).apply()
    }

    fun getString(key: String): String {
        return security.getString(key,"") ?: ""
    }
}