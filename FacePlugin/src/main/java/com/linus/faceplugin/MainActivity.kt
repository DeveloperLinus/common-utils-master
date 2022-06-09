package com.linus.faceplugin

import android.content.Intent
import android.util.Log
import com.linus.bean.IFaceData
import com.linus.commonlib.ui.BaseBindingActivity
import com.linus.commonlib.utils.log
import com.linus.faceplugin.databinding.ActMainBinding
import com.linus.faceplugin.message.BindMessageManager

class MainActivity : BaseBindingActivity<ActMainBinding>(){
    override fun getLayoutId() = R.layout.act_main

    override fun init() {

    }

    override fun initListener() {
        binding.btnSendMessageToMaintain.setOnClickListener {
            val intent = Intent()
            intent.putExtra("KEY", "业务程序发送消息给维护程序")
            val iFaceData = IFaceData(intent)
            val result = BindMessageManager.sendMessage2Maintain(iFaceData)
            Log.d("huqinghui", "业务程序接收到维护程序回复的消息->${result?.intent?.getStringExtra("message")}")
        }

        binding.btnSendMessageToSerial.setOnClickListener {
            val intent = Intent()
            intent.putExtra("KEY", "FacePlugin发送消息给FaceSerial")
            val iFaceData = IFaceData(intent)
            val result = BindMessageManager.sendMessage2Serial(iFaceData)
            log( "FacePlugin接收到FaceSerial回复的消息->${result?.intent?.getStringExtra("message")}")
        }
    }
}