package com.linus.common.kotlin

import org.junit.Test
import java.util.*

class DateUtilTest {
    @Test
    fun test01() {
        val nowDateTime = DateUtil1.getNowDateTime()
        println("nowDateTime->$nowDateTime") // nowDateTime->2022-0729 16:42:23
        val nowTime = DateUtil1.getNowTime()
        println("nowTime->${nowTime}") // nowTime->16:44:53
        val nowTimeDetail = DateUtil1.getNowTimeDetail()
        println("nowTimeDetail->${nowTimeDetail}") // nowTimeDetail->16:46:10.389
    }

    @Test
    fun test02() {
        val formatTime = Date().getFormatTime()
        println("formatTime->$formatTime") // formatTime->20220729164939
        val nowDate = Date().getNowDate()
        println("nowDate->${nowDate}") // nowDate->2022-07-29
        val nowDateTime = Date().getNowDateTime()
        println("nowDateTime->$nowDateTime") // nowDateTime->2022-07-29 16:52:24
        val nowTime = Date().getNowTime()
        println("nowTime->$nowTime") // nowTime->16:52:24
        val nowTimeDetail = Date().getNowTimeDetail()
        println("nowTimeDetail->$nowTimeDetail") // nowTimeDetail->16:52:24.796
    }

    @Test
    fun test03() {
        println("当前日期时间为:${DateUtil3.nowDateTime}") // 当前日期时间为:2022-07-29 17:03:32
        println("当前日期为:${DateUtil3.nowDate}") // 当前日期为:2022-07-29
        println("当前时间为:${DateUtil3.nowTime}") // 当前时间为:17:03:32
        println("当前毫秒时间为:${DateUtil3.nowTimeDetail}") // 当前毫秒时间为:17:03:32.281
        println("当前中文时间的日期为:${DateUtil3.getFormatTime("yyyy年MM์月dd日 HH时mm分ss秒")}")  // 当前中文时间的日期为:2022年07์月29日 17时03分32秒
    }
}