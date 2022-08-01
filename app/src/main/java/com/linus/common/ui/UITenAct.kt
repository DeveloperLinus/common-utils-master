package com.linus.common.ui

import com.linus.common.R
import com.linus.common.databinding.ActivityCalibrationBinding
import com.linus.commonlib.ui.BaseBindingActivity

class UITenAct  : BaseBindingActivity<ActivityCalibrationBinding>()  {
    override fun getLayoutId(): Int {
        return R.layout.activity_calibration
    }

    override fun init() {
    }
}