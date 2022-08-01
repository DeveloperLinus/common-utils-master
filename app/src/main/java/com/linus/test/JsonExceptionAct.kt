package com.linus.test

import android.util.Log
import com.linus.common.R
import com.linus.common.databinding.ActJsonExceptionBinding
import com.linus.commonlib.ui.BaseBindingActivity
import org.json.JSONObject

class JsonExceptionAct: BaseBindingActivity<ActJsonExceptionBinding>()  {
    override fun getLayoutId(): Int {
        return R.layout.act_json_exception
    }

    override fun init() {
        binding.btnJsonException.setOnClickListener {
            val jsonObject = JSONObject("{\"cmd\":\"3350\",\"msg\":\"authentication error,current status is 1\",\"msgCode\":-2,\"snr\":30}")
            val cmd = jsonObject.getString("cmd")
            val msg = jsonObject.getString("msg")
            Log.d("huqinghui", "cmd=${cmd}, msg=${msg}")
            try {
                val errCode = jsonObject.getString("errCode")
            } catch (e: Exception) {
               e.printStackTrace()
                Log.d("huqinghui", "exception:${e.message}")
            }
        }
    }
}