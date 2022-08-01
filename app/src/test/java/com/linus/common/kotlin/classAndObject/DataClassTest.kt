package com.linus.common.kotlin.classAndObject

import org.junit.Test

class DataClassTest {
    data class Plant(var name:String, var stem:String, var leaf:String, var flower:String, var fruit:String, var seed:String)

    @Test
    fun test01() {
        var lotus = Plant("莲", "莲藕", "莲叶","莲花", "莲蓬", "莲子")
        var lotus2 = lotus.copy()
        println("lotus2->${lotus2}") // lotus2->Plant(name=莲, stem=莲藕, leaf=莲叶, flower=莲花, fruit=莲蓬, seed=莲子)
        lotus2 = lotus.copy(flower="荷花") // 指定参数另外赋值
        println("lotus2->${lotus2}") // lotus2->Plant(name=莲, stem=莲藕, leaf=莲叶, flower=荷花, fruit=莲蓬, seed=莲子)
    }
}