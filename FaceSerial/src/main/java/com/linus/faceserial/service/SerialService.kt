package com.linus.faceserial.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.linus.bean.IFaceData
import com.linus.commonlib.utils.log
import com.linus.faceplugin.IFacePlugin
import com.linus.faceserial.IFaceSerial
import com.linus.faceserial.helper.PluginHelper

class SerialService : Service() {
    private var plugin: IFacePlugin? = null
    private val serial = object : IFaceSerial.Stub() {
        override fun sendMessage(message: IFaceData): IFaceData {
            val key = message.intent.getStringExtra("KEY")
            log("FaceSerial接收到key->$key")
            message.intent.putExtra("message", "FaceSerial回复消息222")
            return message
        }

        override fun register(message: IFacePlugin) {
            Log.d("huqinghui", "FaceSerial接收到FacePlugin的注册了")
            plugin = message
            PluginHelper.addPlugin(plugin!!)
        }
    }
    override fun onBind(p0: Intent): IBinder {
        return serial
    }
}