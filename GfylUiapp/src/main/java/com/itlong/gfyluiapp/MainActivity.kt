package com.itlong.gfyluiapp

import android.content.Intent
import android.graphics.Typeface
import com.itlong.gfyluiapp.databinding.ActivityMainBinding
import com.linus.commonlib.ui.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        binding.btnDtPtResult.setOnClickListener {
            val intent = Intent(this, DtptResultAct::class.java)
            startActivity(intent)
        }

        binding.btnAuthFailResultResult.setOnClickListener {
            val intent = Intent(this, AuthFailResultAct::class.java)
            startActivity(intent)
        }
    }
}