package com.akshat.eCommerce

import android.app.Application
import com.akshat.eCommerce.utils.AppConstant
import com.akshat.eCommerce.utils.PreferenceInterface
import com.akshat.eCommerce.utils.Preferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}