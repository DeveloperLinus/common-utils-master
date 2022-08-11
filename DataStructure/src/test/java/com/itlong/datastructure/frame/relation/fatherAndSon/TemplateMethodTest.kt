package com.itlong.datastructure.frame.relation.fatherAndSon

import org.junit.Test

// 模板方法模式
// 解释一下模板方法模式，就是指：一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，
//也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调 用
class TemplateMethodTest {
    abstract class AbstractCalculator {
        /*主方法，实现对本类其它方法的调用*/
        fun calculate(exp: String, opt: String?): Int {
            val array = split(exp, opt)
            return calculate(array[0], array[1])
        }

        /*被子类重写的方法*/
        abstract fun calculate(num1: Int, num2: Int): Int
        private fun split(exp: String, opt: String?): IntArray {
            val array = exp.split(opt!!).toTypedArray()
            val arrayInt = IntArray(2)
            arrayInt[0] = array[0].toInt()
            arrayInt[1] = array[1].toInt()
            return arrayInt
        }
    }

    class Plus : AbstractCalculator() {
        override fun calculate(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }

    class Minus : AbstractCalculator() {
        override fun calculate(num1: Int, num2: Int): Int {
            return num1 - num2
        }
    }

    @Test
    fun test() {
        val exp = "2+8"
        val calculator = Plus()
        val result1 = calculator.calculate(exp, "+")
        val result2 = calculator.calculate(2, 7)
        println("result1->$result1 , result2->$result2")
    }
}