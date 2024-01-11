package com.akshat.eCommerce

import android.app.Application
import com.akshat.eCommerce.utils.AppConstant
import com.akshat.eCommerce.utils.PreferenceInterface
import com.akshat.eCommerce.utils.Preferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application() {
    private lateinit var preference: PreferenceInterface

    override fun onCreate() {
        super.onCreate()
        preference = Preferences(this, AppConstant.SAVE_PREFERENCE_FILENAME)
    }


}