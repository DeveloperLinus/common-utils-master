package com.linus.faceplugin.message

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.RemoteException
import android.os.SystemClock
import com.linus.bean.IFaceData
import com.linus.commonlib.base.BaseBindMessage
import com.linus.commonlib.storage.UiUtils
import java.util.*

object BindMessageManager {
    private var maintainBindMessage: MaintainBindMessage? = null
    private var  serialBindMessage: SerialBindMessage? = null
    private val mBindMessageList: ArrayList<BaseBindMessage> =
        ArrayList()

    fun init() {
        initData()
        initBind()
        initPoll()
    }

    private fun initData() {
        maintainBindMessage = MaintainBindMessage()
        mBindMessageList.add(maintainBindMessage!!)
        serialBindMessage = SerialBindMessage()
        mBindMessageList.add(serialBindMessage!!)
    }

    private fun initBind() {
        for (message in mBindMessageList) {
            try {
                val intent = Intent()
                intent.component = ComponentName(
                    message.getPackageName(),
                    message.getClassName()
                )
                UiUtils.mContext?.let {
                    it.startService(intent)
                    it.bindService(
                        intent,
                        message.getServiceConnection(),
                        Service.BIND_AUTO_CREATE
                    )
                }
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    private fun initPoll() {
        Thread(Runnable {
            while (true) {
                for (message in mBindMessageList) {
                    val binder = message.getBinder()
                    if (message.isAppInstalled() && (binder == null || binder != null && !binder.pingBinder())) {
                        try {
                            val intent = Intent()
                            intent.component = ComponentName(
                                message.getPackageName(),
                                message.getClassName()
                            )
                            UiUtils.mContext?.let {
                                it.startService(intent)
                                it.bindService(
                                    intent,
                                    message.getServiceConnection(),
                                    Service.BIND_AUTO_CREATE
                                )
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
                SystemClock.sleep(5 * 1000.toLong())
            }
        }).start()
    }

    @Throws(RemoteException::class)
    fun sendMessage2Maintain(data: IFaceData): IFaceData? {
        return maintainBindMessage?.sendMessage(data)
    }

    @Throws(RemoteException::class)
    fun sendMessage2Serial(data: IFaceData): IFaceData? {
        return serialBindMessage?.sendMessage(data)
    }
}