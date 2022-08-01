package com.linus.common

import org.junit.Test

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author   HuQingHui
 * @date     2022/7/27
 */
class ChainTestDemo {
    @Test
    fun test01() {
        val handler1= DeviceDetectHandler("AAA")
        val handler2= DeviceDetectHandler("BBB")
        val handler3= DeviceDetectHandler("CCC")
        handler1.setHandler(handler2)
        handler2.setHandler(handler3)
        val result = handler1.detectProtocol()
        println("探测到的最终结果，result->${result}")
    }
}