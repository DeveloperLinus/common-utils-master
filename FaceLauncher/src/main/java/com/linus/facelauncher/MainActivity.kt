package com.linus.facelauncher

import android.content.Intent
import android.os.Handler
import android.util.Log
import com.linus.commonlib.ui.BaseBindingActivity
import com.linus.facelauncher.databinding.ActMainBinding
import java.lang.Exception

class MainActivity : BaseBindingActivity<ActMainBinding>() {
    override fun getLayoutId() = R.layout.act_main
    private val PACKAGE_START = "com.linus.faceplugin"
    private val mHandle = Handler()
    override fun init() {
        mHandle.postDelayed({ startActivity(PACKAGE_START)},6000)
    }
    override fun initListener() {
    }

    private fun startActivity(packageName: String) {
        Log.d("huqinghui", "启动业务程序...")
        val packageManager = packageManager
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent == null) {
            Log.d("huqinghui", "系统未安装业务程序")
            return
        }
        myStartActivity(intent)
    }

    private fun myStartActivity(intent: Intent) {
        try {
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("huqinghui", "系统未安装业务程序，启动失败")
        }
    }
}