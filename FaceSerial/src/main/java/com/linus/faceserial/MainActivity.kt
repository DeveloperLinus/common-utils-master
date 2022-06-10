package com.linus.faceserial
import com.linus.commonlib.ui.BaseBindingActivity
import com.linus.commonlib.utils.log
import com.linus.faceserial.databinding.ActMainBinding
import com.linus.faceserial.helper.PluginHelper


class MainActivity : BaseBindingActivity<ActMainBinding>(){
    override fun getLayoutId() = R.layout.act_main

    override fun init() {

    }

    override fun initListener() {
        binding.btnSendMessageToPlugin.setOnClickListener {
            log("FaceSerial 发送数据给FacePlugin")
            val result = PluginHelper.sendMessage("KEY", "数据来自FaceSerial")
            log("FaceSerial接收到FacePlugin的回复消息, key->${result?.intent?.getStringExtra("message")}")
        }

        binding.btnSendMessageToPlugin2.setOnClickListener {
            log("FaceSerial发送消息给FacePlugin")
            val result =  com.linus.test.PluginHelper.sendMessage("KEY", "数据来自FaceSerial req")
            log("FaceSerial 接收到FacePlugin的回复消息,key->${result?.intent?.getStringExtra("message")}")
        }
    }
}