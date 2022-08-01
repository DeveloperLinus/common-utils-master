package com.linus.common.ui

import com.linus.common.R
import com.linus.common.databinding.ViewAppointmentDtBinding
import com.linus.commonlib.ui.BaseBindingActivity

class UITwoAct  : BaseBindingActivity<ViewAppointmentDtBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.view_appointment_dt
    }

    override fun init() {
    }
}