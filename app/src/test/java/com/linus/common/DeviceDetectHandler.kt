package com.linus.common

import com.itlong.faceplugin.qrcode.protocol.AbstractProtocolHandler

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author   HuQingHui
 * @date     2022/7/27
 */
class DeviceDetectHandler(private val device: String) : AbstractProtocolHandler(), ProtocolHandler {
    override fun detectProtocol(): Int {
        println("现在检测的设备->${device}")
        if (device == "BBB") {
            return 2
        } else {
            return getHandler()?.detectProtocol() ?: -1
        }
    }
}