package com.linus.common.ui

import com.linus.common.R
import com.linus.common.databinding.ViewAppointmentDtPtResultBinding
import com.linus.commonlib.ui.BaseBindingActivity

class UIThreeAct : BaseBindingActivity<ViewAppointmentDtPtResultBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.view_appointment_dt_pt_result
    }

    override fun init() {
        binding.dtName.textSize = resources.getDimension(R.dimen.dt_rs_pt_text_size_large)
    }
}