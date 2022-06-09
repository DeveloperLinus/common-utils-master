package com.linus.faceserial.helper

import android.content.Intent
import android.os.RemoteException
import android.text.TextUtils
import android.util.Log
import com.linus.bean.IFaceData
import com.linus.commonlib.utils.log
import com.linus.faceplugin.IFacePlugin

// 通讯通讯发送消息给业务程序辅助类
object PluginHelper {
    private var plugin: IFacePlugin? = null
    fun addPlugin(plugin: IFacePlugin) {
        PluginHelper.plugin = plugin
    }

    fun sendMessage(key: String, value: Any?) : IFaceData? {
        var iFaceData: IFaceData? = null
        if (TextUtils.isEmpty(key) || value == null) {
            log("发送数据到业务程序失败：key = $key , value = $value")
            return iFaceData
        }
        if (plugin == null) {
            log("发送数据到业务程序失败 plugin 为空，key = $key , value = $value")
            return iFaceData
        }
        val intent = Intent()
        if (value is String) {
            intent.putExtra(key, value as String?)
        } else if (value is Int) {
            intent.putExtra(key, value as Int?)
        } else if (value is Float) {
            intent.putExtra(key, value as Float?)
        } else if (value is Double) {
            intent.putExtra(key, value as Double?)
        } else if (value is Boolean) {
            intent.putExtra(key, value as Boolean?)
        }
        try {
            iFaceData = plugin!!.sendMessage(IFaceData(intent))
        } catch (e: RemoteException) {
            e.printStackTrace()
        } finally {
            return iFaceData
        }
    }
}