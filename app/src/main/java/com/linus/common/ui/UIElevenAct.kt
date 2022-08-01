package com.linus.common.ui

import com.linus.common.R
import com.linus.common.databinding.ActivityCalibrationBinding
import com.linus.common.databinding.ActivityDeviceManageBinding
import com.linus.commonlib.ui.BaseBindingActivity

class UIElevenAct : BaseBindingActivity<ActivityDeviceManageBinding>()  {
    override fun getLayoutId(): Int {
        return R.layout.activity_device_manage
    }

    override fun init() {
    }
}