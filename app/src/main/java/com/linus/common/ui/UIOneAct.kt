package com.linus.common.ui

import com.linus.common.R
import com.linus.common.databinding.ItemDtNameViewBinding
import com.linus.commonlib.ui.BaseBindingActivity

class UIOneAct : BaseBindingActivity<ItemDtNameViewBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.item_dt_name_view
    }

    override fun init() {
    }
}