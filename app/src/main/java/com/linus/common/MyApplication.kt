package com.linus.common

import android.app.Application
import com.linus.commonlib.schedule.Schedule
import com.linus.commonlib.storage.UiUtils
import java.util.concurrent.TimeUnit

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Schedule.getInstance().start(0, 10, TimeUnit.SECONDS)
        UiUtils.mContext = this
    }
}