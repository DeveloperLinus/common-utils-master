package com.linus.commonlib.qrcode

object StringTest {
     fun bytesToHexStr(bArray: ByteArray?): String? {
        if (bArray == null) {
            return ""
        }
        val sb = StringBuffer(bArray.size)
        var sTemp: String
        for (i in bArray.indices) {
            sTemp = Integer.toHexString(0xFF and bArray[i].toInt())
            if (sTemp.length < 2) sb.append(0)
            sb.append(sTemp.toUpperCase())
        }
        return sb.toString()
    }
}