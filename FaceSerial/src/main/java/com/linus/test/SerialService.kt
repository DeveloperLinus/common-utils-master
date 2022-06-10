package com.linus.test

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.linus.commonlib.utils.log

class SerialService : Service() {
    private var plugin:IFacePlugin? = null
    private val serial = object : IFaceSerial.Stub() {
        override fun sendMessage(message: IFaceData): IFaceData {
            val key = message.intent.getStringExtra("KEY")
            log("FaceSerial接收到key->$key")
            message.intent.putExtra("message", "$key ack")
            return message
        }

        override fun register(message: IFacePlugin) {
            log("FaceSerial接收到FacePlugin的注册了22")
            plugin = message
            PluginHelper.addPlugin(plugin = plugin!!)
        }
    }
    override fun onBind(intent: Intent): IBinder {
        return serial
    }
}