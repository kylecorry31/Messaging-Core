package com.kylecorry.messaging_core.infrastructure

import android.Manifest
import android.content.Context
import android.telephony.SmsManager
import com.kylecorry.trailsensecore.infrastructure.system.PermissionUtils

class SmsService(private val context: Context) {

    fun send(to: String, message: String) {
        if (!PermissionUtils.hasPermission(context, Manifest.permission.SEND_SMS)) {
            return
        }
        val sms = SmsManager.getDefault()
        sms.sendTextMessage(to, null, message, null, null)
    }

}