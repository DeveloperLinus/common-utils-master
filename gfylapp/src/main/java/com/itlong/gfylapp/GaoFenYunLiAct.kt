package com.itlong.gfylapp

import android.content.Intent
import com.itlong.gfylapp.databinding.ActGaoFenYunLiMainBinding
import com.linus.commonlib.ui.BaseBindingActivity

class GaoFenYunLiAct : BaseBindingActivity<ActGaoFenYunLiMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.act_gao_fen_yun_li_main
    }

    override fun init() {
        binding.btnDeviceException.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "device_exception")
            startActivity(intent)
        }

        binding.btnAuthFail.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "auth_fail")
            startActivity(intent)
        }

        binding.btnPtAuthSuccessResult1.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "pt_auth_success_result1")
            startActivity(intent)
        }

        binding.btnPtAuthSuccessResult2.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "pt_auth_success_result2")
            startActivity(intent)
        }

        binding.btnVipAuthSuccess.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "vip_auth_success")
            startActivity(intent)
        }

        binding.btnAppointmentDtVipResult1.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "appointment_dt_vip_result1")
            startActivity(intent)
        }

        binding.btnAppointmentDtVipResult2.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "appointment_dt_vip_result2")
            startActivity(intent)
        }

        binding.btnAppointmentDtPtResult1.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "appointment_dt_pt_result1")
            startActivity(intent)
        }

        binding.btnAppointmentDtPtResult2.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "appointment_dt_pt_result2")
            startActivity(intent)
        }
        binding.btnAppointmentDtPtResult3.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "appointment_dt_pt_result3")
            startActivity(intent)
        }

        binding.btnPtGoToSelectDts.setOnClickListener {
            val intent = Intent(this, GaoFenYunLiUIAct::class.java)
            intent.putExtra("page", "pt_go_to_select_dts")
            startActivity(intent)
        }
    }
}