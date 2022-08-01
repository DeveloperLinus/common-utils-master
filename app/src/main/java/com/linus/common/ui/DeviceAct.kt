package com.linus.common.ui

import android.content.Context
import android.view.WindowManager
import com.linus.common.R
import com.linus.common.databinding.ActDeviceBinding
import com.linus.commonlib.storage.UiUtils
import com.linus.commonlib.ui.BaseBindingActivity
import com.linus.commonlib.utils.DpUtil
import com.linus.commonlib.utils.log

class DeviceAct : BaseBindingActivity<ActDeviceBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.act_device
    }

    override fun init() {

    }

    override fun initListener() {
        binding.btnMethod1.setOnClickListener {
            val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val width = wm.defaultDisplay.width
            val height = wm.defaultDisplay.height
            binding.textMsg.text = "屏幕宽:$width,屏幕高:$height"
        }

        binding.btnDp2px.setOnClickListener {
            log("100dp=${DpUtil.dp2px(UiUtils.mContext, 100f)}px")
        }
        binding.btnSp2px.setOnClickListener {
            log("100sp=${DpUtil.sp2px(UiUtils.mContext, 100f)}px")
        }
    }
}