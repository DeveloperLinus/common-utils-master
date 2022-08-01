package com.linus.common.kotlin

import java.text.SimpleDateFormat
import java.util.*

object DateUtil1 {
     fun getNowDateTime() : String {
        val sdf = SimpleDateFormat("yyyy-MMdd HH:mm:ss");
        return sdf.format(Date())
    }

    fun getNowTime() : String{
        val sdf =  SimpleDateFormat("HH:mm:ss");
        return sdf.format(Date());
    }

    fun getNowTimeDetail() : String{
        val sdf = SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(Date());
    }
}