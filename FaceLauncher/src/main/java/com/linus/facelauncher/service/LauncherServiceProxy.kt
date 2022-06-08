package com.linus.facelauncher.service

import android.app.Service
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.IBinder
import com.linus.facelauncher.IFaceLauncher

class LauncherServiceProxy : Service() {
    private val launcher = object: IFaceLauncher.Stub() {
        override fun getVersion(): String {
            return "${getVersionCode()}"
        }

        override fun getVersionName(): String {
            return this@LauncherServiceProxy.getVersionName()
        }
    }
    override fun onBind(p0: Intent): IBinder {
        return launcher
    }
    // 获取桌面程序的versionCode
    private fun getVersionCode(): Int {
        try {
            var pinfo: PackageInfo? = null
            pinfo = packageManager
                .getPackageInfo(
                    packageName,
                    PackageManager.GET_CONFIGURATIONS
                )
            return pinfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return Int.MAX_VALUE
    }

    // 获取桌面程序的versionName
    private fun getVersionName(): String {
        try {
            var pinfo: PackageInfo? = null
            pinfo = packageManager
                .getPackageInfo(
                    packageName,
                    PackageManager.GET_CONFIGURATIONS
                )
            return pinfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return ""
    }
}