package com.linus.facemaintain

import android.app.Application
import com.linus.commonlib.storage.UiUtils

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        UiUtils.mContext = this
    }
}