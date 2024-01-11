package com.akshat.eCommerce.utils

import android.content.Context
import android.content.SharedPreferences
import android.view.Display.Mode
import com.akshat.eCommerce.UserData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Preferences(context: Context, fileName: String): PreferenceInterface {
    private val SAVE_DATA ="saveData"
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    private val preferenceEditor:SharedPreferences.Editor = sharedPreferences.edit()
    override fun saveData(data: UserData) {
        val gson = Gson().toJson(data)
        preferenceEditor.putString(SAVE_DATA, gson?: "")
    }

    override fun getData(): UserData {
        val savedData = sharedPreferences.getString(SAVE_DATA, "")
//        val type = object : TypeToken<UserData>(){}.type
        return  Gson().fromJson(savedData, UserData::class.java)
    }

    override fun clearData() {
        preferenceEditor.clear()
    }

}