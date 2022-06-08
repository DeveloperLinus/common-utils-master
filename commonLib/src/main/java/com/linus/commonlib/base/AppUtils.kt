package com.linus.commonlib.base

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log

object AppUtils {
    fun getApkPackageName(context: Context, apkPath: String): String {
        var packageName = ""
        try {
            val pm = context.packageManager
            val pkgInfo = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES)
            if (pkgInfo != null) {
                val appInfo = pkgInfo.applicationInfo
                /* 必须加这两句，不然下面icon获取是default icon而不是应用包的icon */
                appInfo.sourceDir = apkPath
                appInfo.publicSourceDir = apkPath
                // 得到应用名 
                // 得到应用名 
                val appName = pm.getApplicationLabel(appInfo).toString()
                // 得到包名 
                // 得到包名 
                packageName = appInfo.packageName
                // 得到版本信息 
                // 得到版本信息 
                val version = pkgInfo.versionName
                val versionCode = pkgInfo.versionCode
                val pkgInfoStr = String.format("PackageName:%s, Vesion: %s, AppName: %s, versionCode: %s", packageName, version, appName, versionCode)
                Log.i("huqinghui", String.format("PkgInfo: %s", pkgInfoStr))
                return packageName
            }
        } catch (t: Throwable) {
        }
        return packageName
    }
}