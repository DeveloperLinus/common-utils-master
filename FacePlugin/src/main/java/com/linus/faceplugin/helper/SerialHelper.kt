package com.linus.faceplugin.helper

import android.content.Intent
import android.text.TextUtils
import com.linus.bean.IFaceData
import com.linus.commonlib.utils.log
import com.linus.faceserial.IFaceSerial

// 业务程序发送消息到通讯程序的辅助类
object SerialHelper {
    private var serial: IFaceSerial? = null

    fun addSerial(serial: IFaceSerial?) {
        SerialHelper.serial = serial
    }

    fun sendMessage(key: String, value: Any): IFaceData? {
        if (TextUtils.isEmpty(key) || value == null) {
            log("发送数据到通讯程序失败：key = $key , value = $value")
            return null
        }
        if (serial == null) {
            log("发送数据到通讯程序失败 serial 为空，key = $key , value = $value")
            return null
        }

        val intent = Intent()
        if (value is String) {
            intent.putExtra(key, value)
        } else if (value is Int) {
            intent.putExtra(key, value)
        } else if (value is Float) {
            intent.putExtra(key, value)
        } else if (value is Double) {
            intent.putExtra(key, value)
        } else if (value is Boolean) {
            intent.putExtra(key, value)
        }
        try {
            log("发送数据到通讯程序，key = $key , value = $value")
            return serial!!.sendMessage(IFaceData(intent))
        } catch (e: Exception) {
            e.printStackTrace()
            log("发送数据到通讯程序失败，key = " + key + " , value = " + value + " , e = " + e.message)
        }
        return null
    }
}