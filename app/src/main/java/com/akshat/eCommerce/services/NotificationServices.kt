package com.akshat.eCommerce.services

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.akshat.eCommerce.MainActivity
import com.akshat.eCommerce.services.Notification.Companion.CHANNELID


class NotificationServices : Service() {
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val input = intent.getStringExtra("inputExtra")
        val input1 = intent.getStringExtra("inputExtra1")
        val input2 = intent.getStringExtra("inputExtra2")
        val input3 = intent.getStringExtra("coin")
        val input5 = intent.getStringExtra("coin2")
        val input6 = intent.getStringExtra("app")
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )
        val notification: Notification = NotificationCompat.Builder(
            this,
            CHANNELID
        )
            .setContentTitle("finding true friend dog")
            .setContentText(input)
            .setContentText(input1)
            .setContentText(input2)
            .setContentText(input3)
            .setContentText(input5)
            .setContentText(input6)
//            .setSmallIcon(R.drawable.noti)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}