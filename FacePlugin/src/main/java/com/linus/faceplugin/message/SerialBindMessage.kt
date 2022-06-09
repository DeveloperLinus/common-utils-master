package com.linus.faceplugin.message

import android.content.ComponentName
import android.content.ServiceConnection
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.IBinder
import android.os.RemoteException
import com.linus.commonlib.utils.log
import com.linus.commonlib.base.BaseBindMessage
import com.linus.commonlib.storage.UiUtils
import com.linus.faceplugin.IFacePlugin
import com.linus.faceplugin.helper.SerialHelper
import com.linus.faceserial.IFaceSerial
import  com.linus.bean.IFaceData
import com.linus.faceplugin.listener.ISerialListener

// 与serial进行aidl进程间通讯
class SerialBindMessage : BaseBindMessage() {
    private var serial:IFaceSerial? = null
    private val plugin:IFacePlugin? = object : IFacePlugin.Stub() {
        override fun sendMessage(message: IFaceData): IFaceData {
            val key = message.intent.getStringExtra("KEY")
           log("FacePlugin接收到FaceSerial发送过来的消息,key->$key")
            message.intent.putExtra("message", "业务程序回复通讯程序消息333")
            return message
        }
    }
    private val serialServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
           log("绑定service serial失败")
            SerialHelper.addSerial(null)
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            log("绑定service serial成功")
            serial = IFaceSerial.Stub.asInterface(service)
            SerialHelper.addSerial(serial!!)
            serial!!.register(plugin)
        }
    }

    private var iSerialListener:ISerialListener? = null

    // 设置通讯程序消息监听回调接口
    fun setSerialListener(listener: ISerialListener) {
        iSerialListener = listener
    }

    // 业务程序发送消息给通讯通讯接口
    @Throws(RemoteException::class)
    fun sendMessage(data: IFaceData): IFaceData? {
      return  serial?.let {
           it.sendMessage(data)
       }
    }

    override fun getBinder(): IBinder? {
        return serial?.asBinder()
    }

    override fun getPackageName(): String {
        return "com.linus.faceserial"
    }

    override fun getClassName(): String {
        return "com.linus.faceserial.service.SerialService"
    }

    override fun getServiceConnection(): ServiceConnection {
        return serialServiceConnection
    }

    override fun isAppInstalled(): Boolean {
        var packageInfo: PackageInfo? = null
        try {
            packageInfo = UiUtils.mContext?.packageManager?.getPackageInfo(getPackageName(), 0)
        } catch (e: PackageManager.NameNotFoundException) {
            packageInfo = null
            e.printStackTrace()
        }
        return packageInfo != null
    }
}