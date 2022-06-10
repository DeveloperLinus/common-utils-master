package com.linus.test

import android.content.ComponentName
import android.content.ServiceConnection
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.IBinder
import android.os.RemoteException
import com.linus.commonlib.base.BaseBindMessage
import com.linus.commonlib.storage.UiUtils
import com.linus.commonlib.utils.log

// 用于测试aidl包名路径不同是否可以正常通讯,路径名不同会报错 java.lang.SecurityException: Binder invocation to an incorrect interface
class SerialBindMessage2 : BaseBindMessage() {
    private var serial: IFaceSerial? = null
    private val plugin:IFacePlugin = object : IFacePlugin.Stub() {
        override fun sendMessage(message: IFaceData): IFaceData {
            val key = message.intent.getStringExtra("KEY")
            log("FacePlugin接收到FaceSerial传递过来的消息key->$key")
            message.intent.putExtra("message", "FacePlugin回复的消息22+ack")
            return message
        }
    }

    private val serialServiceConnection = object  : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            log("FacePlugin2绑定service serial失败")
            serial = null
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            log("FacePlugin2绑定service serial成功")
            serial = IFaceSerial.Stub.asInterface(service).also {
                it.register(plugin)
            }
        }
    }
    override fun getBinder(): IBinder? {
        return serial?.asBinder()
    }

    // 业务程序发送消息给通讯通讯接口
    @Throws(RemoteException::class)
    fun sendMessage(data: IFaceData): IFaceData? {
        return  serial?.let {
            it.sendMessage(data)
        }
    }

    override fun getPackageName(): String {
        return "com.linus.faceserial"
    }

    override fun getClassName(): String {
        return "com.linus.test.SerialService"
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