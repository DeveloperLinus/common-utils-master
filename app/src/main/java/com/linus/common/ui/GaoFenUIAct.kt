package com.linus.common.ui

import android.content.Intent
import com.linus.common.R
import com.linus.common.databinding.ActGaoFengYunLiBinding
import com.linus.commonlib.ui.BaseBindingActivity

class GaoFenUIAct : BaseBindingActivity<ActGaoFengYunLiBinding>() {
    override fun getLayoutId(): Int {
       return R.layout.act_gao_feng_yun_li
    }

    override fun init() {
        binding.btnGaoFengYunLi.setOnClickListener {
            startActivity(Intent(this, GaoFenYunLiAct::class.java))
        }
    }
}