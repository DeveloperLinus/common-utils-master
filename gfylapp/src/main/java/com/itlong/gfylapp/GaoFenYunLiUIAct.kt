package com.itlong.gfylapp

import android.util.Log
import com.itlong.gfylapp.databinding.ActGaoFenYunLiUiBinding
import com.linus.commonlib.ui.BaseBindingActivity

class GaoFenYunLiUIAct : BaseBindingActivity<ActGaoFenYunLiUiBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.act_gao_fen_yun_li_ui
    }

    override fun init() {
        val page = intent.extras?.get("page")
        when(page) {
            "device_exception" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.device_exception)
            "auth_fail" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.auth_fail)
            "pt_auth_success_result1" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.pt_auth_success_result1)
            "pt_auth_success_result2" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.pt_auth_success_result2)
            "vip_auth_success" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.vip_auth_success)
            "appointment_dt_vip_result1" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.view_appointment_dt_vip_result1)
            "appointment_dt_vip_result2" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.view_appointment_dt_vip_result2)
            "appointment_dt_pt_result1" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.view_appointment_dt_pt_result1)
            "appointment_dt_pt_result2" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.view_appointment_dt_pt_result2)
            "appointment_dt_pt_result3" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.view_appointment_dt_pt_result3)
            "pt_go_to_select_dts" -> binding.ivGaoFengYunLi.background = resources.getDrawable(R.mipmap.view_pt_go_to_select_dts)
            else -> Log.d("GaoFenYunLi", "页面不存在")
        }
    }
}