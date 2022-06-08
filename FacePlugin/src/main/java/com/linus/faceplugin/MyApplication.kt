package com.linus.faceplugin

import android.app.Application
import com.linus.commonlib.storage.UiUtils
import com.linus.faceplugin.message.BindMessageManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        UiUtils.mContext = this
        BindMessageManager.init()
    }
}