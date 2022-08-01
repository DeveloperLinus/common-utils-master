package com.linus.common.kotlin

import com.linus.commonlib.utils.log
import org.junit.Test

class ReifiedDemoTest {
    private fun setArrayNumber(array:Array<Number>) {
        var str = "数组元素依次排序: "
        for (item in array) {
            str = "$str$item, "
        }
        log("拼接之后的字符串str->$str")
    }

    private  inline  fun <reified T : Number>setArrayNumber2(array:Array<T>) {
        var str = "数组元素依次排序: "
        for (item in array) {
            str = "$str$item, "
        }
        println("拼接之后的字符串str->$str")
    }

    @Test
    fun test01() {
        val intArray = arrayOf(1, 2, 3, 4)
        val doubleArray = arrayOf(1.1, 2.2, 3.3)
        val floatArray = arrayOf(1.0f, 2.0f, 3.0f)

        // Int,Float,Double都继承于Number，却无法使用下面的入参
//        setArrayNumber(intArray)
//        setArrayNumber(floatArray)
//        setArrayNumber(doubleArray)

        // 只有内联函数才可以被具体化
        setArrayNumber2(intArray) // 拼接之后的字符串str->数组元素依次排序: 1, 2, 3, 4,
        setArrayNumber2(floatArray) // 拼接之后的字符串str->数组元素依次排序: 1.0, 2.0, 3.0,
        setArrayNumber2(doubleArray) // 拼接之后的字符串str->数组元素依次排序: 1.1, 2.2, 3.3,
    }

    private fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in array)
            if (max == null || greater(item, max))
                max = item
        return max
    }

    @Test
    fun test02() {
        val stringArray = arrayOf("How", "do", "you", "do", "I'm", "Fines")
        println("max1->${stringArray.max()}") // max1->you
        println("字符串数据按长度比较的最大值->${maxCustom(stringArray) { a, b -> a.length > b.length}}") // 字符串数据按长度比较的最大值->Fines
    }

    // 扩展函数结合泛型
    private fun <T> Array<T>.swap(pos1: Int, pos2: Int) {
        val tmp = this[pos1]
        this[pos1] = this[pos2]
        this[pos2] = tmp
    }

    @Test
    fun test03() {
        val intArray = arrayOf(1, 2, 3, 4, 5)
        intArray.swap(0,2)
        println("intArray->${intArray.toList()}") // intArray->[3, 2, 1, 4, 5]
        val doubleArray = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
        doubleArray.swap(0, 2)
        println("doubleArray->${doubleArray.toList()}") // doubleArray->[3.0, 2.0, 1.0, 4.0, 5.0]
    }

    // 扩展高阶函数
    private fun <T> Array<T>.maxCustomize(greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in this)
            if (max == null || greater(item, max))
                max = item
        return max
    }
    
    @Test
    fun test04() {
        val stringArray = arrayOf("How", "do", "you", "do", "I'm", "Fines")
        val max1 = stringArray.maxCustomize { s1, s2 ->  s1.length > s2.length}
        println("max1->${max1}") // max->Fines
        val max2 = stringArray.maxCustomize { s1, s2 ->  s1 > s2}
        println("max2->$max2") // max2->you
    }
}