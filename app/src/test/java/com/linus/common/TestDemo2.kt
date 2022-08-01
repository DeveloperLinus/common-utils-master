package com.linus.common

import com.linus.commonlib.utils.HexUtils
import org.junit.Test

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author   HuQingHui
 * @date     2022/7/26
 */
class TestDemo2 {
    private val ackEnd = "3B03" // 设备应答后缀
    private val ackStart = "020130303030" // 设备应答前缀
    private val sRegex =Regex("020130303030.*?3B03", RegexOption.IGNORE_CASE)
    @Test
    fun test03() {
        val s1 = "<STX><SOH>0000"
        val byteArray = s1.toByteArray()
        println("byteArray:${HexUtils.bytes2hex(byteArray)}")
    }

    @Test
    fun test02() {
        var result = "11111122222222222\u0002\u00010000@SCNMOD2\u0006;\u000333333\u0002\u00010000@SCNMOD2\u0006;\u0003"
        val data = HexUtils.bytes2hex(result.toByteArray())
        println("接收到的指令回复内容->${result}, data->$data")
        if (data.contains(sRegex)) { // 过滤掉指令回复的数据
            sRegex.findAll(data).forEach {
                println("item->${String(HexUtils.hex2bytes(it.value))}")
            }
            result = String(HexUtils.hex2bytes(data.replace(sRegex, "")))
            if (result.isNotEmpty()) {
                println("result->$result")
            }
        } else {
            println("扫码数据->$result")  // 扫码数据
        }
    }
}