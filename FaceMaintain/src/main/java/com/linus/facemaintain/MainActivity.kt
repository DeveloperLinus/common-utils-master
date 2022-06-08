package com.linus.facemaintain

import com.linus.commonlib.ui.BaseBindingActivity
import com.linus.facemaintain.databinding.ActMainBinding

class MainActivity : BaseBindingActivity<ActMainBinding>(){
    override fun getLayoutId() = R.layout.act_main

    override fun init() {

    }

    override fun initListener() {
        binding.btnPrepareConnect.setOnClickListener {

        }
    }
}