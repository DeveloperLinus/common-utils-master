package com.linus.facemaintain.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.linus.bean.IFaceData
import com.linus.facemaintain.IFaceMaintain
import com.linus.faceplugin.IFacePlugin

class FaceServiceProxy : Service() {
    private var plugin: IFacePlugin? = null
    private val maintain = object : IFaceMaintain.Stub() {
        override fun sendMessage(message: IFaceData): IFaceData {
            val key = message.intent.getStringExtra("KEY")
            Log.d("huqinghui", "获取到的key->$key")
            message.intent.putExtra("message", "维护程序回复消息111")
            return message
        }

        override fun register(message: IFacePlugin?) {
            Log.d("huqinghui", "FaceMaintain接收到FacePlugin的注册了")
            plugin = message
        }
    }
    override fun onBind(p0: Intent?): IBinder {
        return maintain
    }
}