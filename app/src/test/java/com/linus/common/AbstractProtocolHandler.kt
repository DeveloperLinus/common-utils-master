package com.itlong.faceplugin.qrcode.protocol

import com.linus.common.ProtocolHandler

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author   HuQingHui
 * @date     2022/7/27
 */
abstract class AbstractProtocolHandler {
    private var handler: ProtocolHandler? = null
    open fun getHandler(): ProtocolHandler? {
        return handler
    }

    open fun setHandler(handler: ProtocolHandler?) {
        this.handler = handler
    }
}