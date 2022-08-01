package com.linus.common.ui

import android.content.Intent
import com.linus.common.R
import com.linus.common.databinding.ActUiBinding
import com.linus.common.databinding.ViewAppointmentDtBinding
import com.linus.commonlib.ui.BaseBindingActivity

class UIAct : BaseBindingActivity<ActUiBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.act_ui
    }

    override fun init() {
        binding.btn1.setOnClickListener {
            startActivity(Intent(this, UIOneAct::class.java))
        }
        binding.btn2.setOnClickListener {
            startActivity(Intent(this, UITwoAct::class.java))
        }
        binding.btn3.setOnClickListener {
            startActivity(Intent(this, UIThreeAct::class.java))
        }
        binding.btn4.setOnClickListener {
            startActivity(Intent(this, UIFourAct::class.java))
        }
        binding.btn5.setOnClickListener {
            startActivity(Intent(this, UIFiveAct::class.java))
        }
        binding.btn6.setOnClickListener {
            startActivity(Intent(this, UISixAct::class.java))
        }
        binding.btn7.setOnClickListener {
            startActivity(Intent(this, UISevenAct::class.java))
        }
        binding.btn8.setOnClickListener {
            startActivity(Intent(this, UIEightAct::class.java))
        }
        binding.btn10.setOnClickListener {
            startActivity(Intent(this, UITenAct::class.java))
        }
        binding.btn11.setOnClickListener {
            startActivity(Intent(this, UIElevenAct::class.java))
        }
        binding.btn12.setOnClickListener {
            startActivity(Intent(this, UIBackgroundAct::class.java))
        }
    }
}