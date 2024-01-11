package com.akshat.eCommerce.utils

import com.akshat.eCommerce.UserData

interface PreferenceInterface {
    fun saveData(data: UserData)
    fun getData(): UserData
    fun clearData()
}