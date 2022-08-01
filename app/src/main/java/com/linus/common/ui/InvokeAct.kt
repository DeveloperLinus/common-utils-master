package com.linus.common.ui

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.linus.common.R
import com.linus.common.databinding.ActInvokeBinding
import com.linus.commonlib.ui.BaseBindingActivity
import java.util.concurrent.ConcurrentHashMap

class InvokeAct : BaseBindingActivity<ActInvokeBinding>() {
    private val taskList = ConcurrentHashMap<Long, ((respData: ByteArray?) -> Unit)?>()
    private val handler = Handler(Looper.getMainLooper())
    private val apiCall: ((sb: StringBuffer, sn: Long, block: (data: String?) -> Unit) -> (respData: ByteArray?) -> Unit) = { sb, sn, block ->
        { p0 ->
            if (p0 != null && p0.isNotEmpty()) {
                sb.append(String(p0))
                block.invoke(sb.toString())
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.act_invoke
    }

    override fun init() {
        binding.btnRecQr.setOnClickListener {
            for (index in 0..5) {
                Thread.sleep(10)
                val data = byteArrayOf(0x43, 0x35, 0x36, 0x44)
                log("收到数据 ${String(data)}")
                for (task in taskList) {
                    task.value?.invoke(data)
                }
            }
        }
        val sb = StringBuffer()
        val handler = Handler(Looper.getMainLooper())
        val callback = Runnable {
            var result = sb.toString().trim() // 把末尾的空字符过滤掉
            log("拼接出的扫码数据->$result")
            sb.setLength(0)
        }
        listen(1000L) { packetData ->
            packetData?.let { p0 ->
                Thread.sleep(100)
                sb.append(String(p0))
                // 100ms后, 自动清除buffer, 防止旧数据影响下次扫码
                handler.removeCallbacks(callback)
                handler.postDelayed(callback, 100)
            }
            val sb = StringBuffer()
            request(1,   apiCall.invoke(sb, 1) {
                Thread.sleep(10)
                log("指令响应数据->$it")
            })
        }
    }

    private fun request(sn: Long, block: (respData: ByteArray?) -> Unit) {
        taskList[sn] = block
    }

    private fun listen(sn: Long, block: (respData: ByteArray?) -> Unit) {
        taskList[sn] = block
    }

    private fun log(msg: String) {
        Log.d("InvokeAct", msg)
    }
}