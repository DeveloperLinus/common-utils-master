package com.linus.common.ui

import android.util.Log
import com.linus.common.R
import com.linus.common.base.BaseBindingActivity
import com.linus.common.databinding.ActMainBinding
import com.linus.commonlib.schedule.IncrementUpDataSchedule
import com.linus.commonlib.schedule.RecordUpDataSchedule
import com.linus.commonlib.thread.ThreadPoolProxyFactory
import java.util.concurrent.Callable

class MainActivity : BaseBindingActivity<ActMainBinding>() {
    override fun getLayoutId() = R.layout.act_main

    override fun init() {

    }

    override fun initListener() {
        super.initListener()
        binding.btnSubmit.setOnClickListener {
            val call = ThreadPoolProxyFactory.singleThreadPool?.submit(Callable<String> {
                Thread.sleep(10000)
                "Finish call"
            }) // 会阻塞
            call?.let {
                val result = it.get()
                Log.d("debug", "i get message, result->$result")
            }
        }

        binding.btnIncrementUpData.setOnClickListener {
            IncrementUpDataSchedule.addTask()
        }
        binding.btnRemoveIncrementUp.setOnClickListener {
            IncrementUpDataSchedule.removeTask()
        }
        binding.btnRecordUpData.setOnClickListener {
            RecordUpDataSchedule.addTask()
        }
        binding.btnRemoveRecordUp.setOnClickListener {
            RecordUpDataSchedule.removeTask()
        }
    }
}