package com.linus.faceplugin.message

import android.content.ComponentName
import android.content.ServiceConnection
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import com.linus.bean.IFaceData
import com.linus.commonlib.base.BaseBindMessage
import com.linus.commonlib.storage.UiUtils
import com.linus.facemaintain.IFaceMaintain
import com.linus.faceplugin.IFacePlugin

// 与maintain程序aidl通讯消息
class MaintainBindMessage : BaseBindMessage() {
    private var maintain: IFaceMaintain? = null
    private val plugin = object : IFacePlugin.Stub() {
        override fun sendMessage(message: IFaceData): IFaceData {
            try {
                val key = message.intent.getStringExtra("KEY")
                Log.d("huqinghui", "发送给Plugin的消息,key->$key")
                message.intent.putExtra("message", "plugin程序回复消息")
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return message
        }
    }
    private val mFaceServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName) {
            Log.d("huqinghui", "绑定service maintain失败")
        }

        override fun onServiceConnected(p0: ComponentName, p1: IBinder) {
            Log.d("huqinghui", "绑定service maintain成功")
            maintain = IFaceMaintain.Stub.asInterface(p1)
            try {
                maintain?.register(plugin)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getBinder(): IBinder? {
        return maintain?.asBinder()
    }

    override fun getPackageName(): String {
        return "com.linus.facemaintain"
    }

    override fun getClassName(): String {
        return "com.linus.facemaintain.service.FaceServiceProxy"
    }

    override fun getServiceConnection(): ServiceConnection {
        return mFaceServiceConnection
    }

    override fun isAppInstalled(): Boolean {
        var packageInfo: PackageInfo? = null
        try {
            packageInfo =
                UiUtils.mContext?.packageManager?.getPackageInfo(getPackageName(), 0)
        } catch (e: PackageManager.NameNotFoundException) {
            packageInfo = null
            e.printStackTrace()
        }
        return packageInfo != null
    }

    @Throws(RemoteException::class)
    fun sendMessage(data: IFaceData): IFaceData? {
        var iFaceData: IFaceData? = null
        if (maintain != null) {
            iFaceData = maintain?.sendMessage(data)
        }
        return iFaceData
    }
}