package com.dog.truefrienddog.services

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class Notification : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationchannel()
    }

    private fun createNotificationchannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNELID,
                "Example S C",
                NotificationManager.IMPORTANCE_NONE
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }

    companion object {
        const val CHANNELID = "EXAMPLESERVICECHANNEL"
    }
}