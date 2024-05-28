package com.akshat.eCommerce.utils

import android.content.Context
import android.content.SharedPreferences
import android.view.Display.Mode
import com.akshat.eCommerce.UserData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Preferences(context: Context) {
    private val SAVE_DATA ="saveDatadfdfdfd"
    private val PREF_IS_MINING_ENABLE = "PREF_IS_MINING_ENABLE343737473843723232"
    private val MY_PREFERNECE_NAME = "PREFbANEDHFJHFDJHFH"
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(MY_PREFERNECE_NAME, Context.MODE_PRIVATE)
    private val preferenceEditor:SharedPreferences.Editor = sharedPreferences.edit()
     fun saveData(data: UserData) {
        val gson = Gson().toJson(data)
        preferenceEditor.putString(SAVE_DATA, gson?: "")
    }

     fun getData(): UserData {
        val savedData = sharedPreferences.getString(SAVE_DATA, "")
//        val type = object : TypeToken<UserData>(){}.type
        return  Gson().fromJson(savedData, UserData::class.java)
    }

     fun clearData() {
        preferenceEditor.clear()
    }

    fun getIsLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(PREF_IS_MINING_ENABLE, false)
    }

    fun saveIsLoggedIn(context: Context, totalpass: Boolean) {
        preferenceEditor.putBoolean(PREF_IS_MINING_ENABLE, totalpass)
        preferenceEditor.apply()
    }

}