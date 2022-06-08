package com.linus.common.ui

import com.linus.common.R
import com.linus.common.base.BaseBindingActivity
import com.linus.common.databinding.ActStorageBinding
import com.linus.commonlib.function.invoke.log
import com.linus.commonlib.storage.StorageUtil

class StorageAct  : BaseBindingActivity<ActStorageBinding>()  {
    override fun getLayoutId(): Int {
        return R.layout.act_storage
    }

    override fun init() {

    }

    override fun initListener() {
        super.initListener()
        binding.btnGetStorageA.setOnClickListener {
            val path = StorageUtil.getPathA()
            log("pathA->$path")
        }

        binding.btnGetStorageB.setOnClickListener {
            val path = StorageUtil.getPathB()
            log("pathB->$path")
        }
    }
}