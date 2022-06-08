package com.linus.commonlib.base

import android.content.ServiceConnection
import android.os.IBinder

abstract  class BaseBindMessage {
    abstract fun getBinder(): IBinder?

    abstract fun getPackageName(): String

    abstract fun getClassName(): String

    abstract fun getServiceConnection(): ServiceConnection

    abstract fun isAppInstalled(): Boolean
}