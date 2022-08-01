package com.linus.common.kotlin.classAndObject

import org.junit.Test

class TemplateClassTest {
    class River<T> (var name:String, var length:T) {
        fun getInfo():String {
            var unit:String = when (length) {
                is String -> "米"
                is Number -> "m"
                else -> ""
            }
            return "${name}的长度是$length$unit "
        }
    }

    @Test
    fun test01() {
        val river1 = River("小溪", 100)
        println("${river1.getInfo()}") // 小溪的长度是100m
        val river2 = River("小溪", 99.9f)
        println("${river2.getInfo()}") // 小溪的长度是99.9m
        val river3 = River("小溪", 50.5)
        println("${river3.getInfo()}") // 小溪的长度是50.5m
        val river4 = River("小溪", "一千")
        println("${river4.getInfo()}") // 小溪的长度是一千米
    }
}