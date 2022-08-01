package com.linus.common.ui

import android.os.Handler
import com.linus.common.R
import com.linus.common.databinding.ActConcatBinding
import com.linus.commonlib.ui.BaseBindingActivity

class ConcatAct : BaseBindingActivity<ActConcatBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.act_concat
    }

    override fun init() {
        binding.btnRecQr.setOnClickListener {
            concat()
        }
    }

    private fun concat() {
        val sb = StringBuffer()
        val handler = Handler()
        var callback = Runnable {
            val result = sb.toString().trim() // 把末尾的空字符包括\r过滤掉
            binding.textMsg.text = "$result"
            sb.setLength(0)
        }
        val strArray = arrayOf("ITL:{L:0058,V:10,U:0000002,M:35", ",H:00,I:0001,T:2207251640,P:0082", " ,S:0000,Q:{N1:5,X1:8,Y:8},K:CF1D", "C56D}")
        for (index in 0..3) {
            Thread.sleep(20)
            sb.append(strArray[index])
            // 100ms后, 自动清除buffer, 防止旧数据影响下次扫码
            handler.removeCallbacks(callback)
            handler.postDelayed(callback, 100)
        }
    }

    private fun output() {
        println("result->${hex2String("49544c3a7b4c3a303035382c563a31302c553a303030303030322c4d3a3335")}") // ITL:{L:0058,V:10,U:0000002,M:35
        println("result->${hex2String("2c483a30302c493a303030312c543a323230373235313634302c503a30303832")}") // ,H:00,I:0001,T:2207251640,P:0082
        println("result->${hex2String("2c533a303030302c513a7b4e313a352c58313a382c593a387d2c4b3a43463144")}") // ,S:0000,Q:{N1:5,X1:8,Y:8},K:CF1D
        println("result->${hex2String("433536447d")}") // C56D}
    }

    private fun hex2String(input: String): String? {
        var s = input
        val baKeyword = ByteArray(s.length / 2)
        for (i in baKeyword.indices) {
            try {
                baKeyword[i] = (0xff and s.substring(i * 2, i * 2 + 2).toInt(16)).toByte()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        try {
            s = String(baKeyword, Charsets.UTF_8)
        } catch (e1: Exception) {
            e1.printStackTrace()
        }
        return s
    }
}