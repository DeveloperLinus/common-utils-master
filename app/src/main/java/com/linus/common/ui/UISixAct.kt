package com.linus.common.ui

import com.linus.common.R
import com.linus.common.databinding.ViewGoToSelectDtsBinding
import com.linus.commonlib.ui.BaseBindingActivity
import com.linus.liu.showruzeltui.DtInfo

class UISixAct : BaseBindingActivity<ViewGoToSelectDtsBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.view_go_to_select_dts
    }

    override fun init() {
        val  dtNames  = mutableListOf<DtInfo>()
        dtNames.add(DtInfo("2号梯"))
        dtNames.add(DtInfo("3号梯"))
        dtNames.add(DtInfo("4号梯"))
        dtNames.add(DtInfo("1号梯"))
        binding.dtNameMll.setVipAndDtNames(true, dtNames)
    }
}