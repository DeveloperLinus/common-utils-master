package com.itlong.datastructure.frame.relation.fatherAndSon

import org.junit.Test

// 策略模式
// 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到
//使用算法的客户。需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计
//一个抽象类（可有可无，属于辅助类），提供辅助函数
// 策略模式的决定权在用户，系统本身提供不同算法的实现，新增或者删除算法，对各种算法做封装。因
// 此，策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可。
class StrategyTest {
    interface ICalculator {
        fun calculate(exp: String) : Int
    }

    abstract class AbstractCalculator {
        fun split(exp: String, opt: String): IntArray {
            val array = exp.split(opt!!).toTypedArray()
            val arrayInt = IntArray(2)
            arrayInt[0] = array[0].toInt()
            arrayInt[1] = array[1].toInt()
            return arrayInt
        }
    }

    class Plus : AbstractCalculator(), ICalculator {
        override fun calculate(exp: String): Int {
            val arrayInt = split(exp,"+")
            return arrayInt[0]+arrayInt[1]
        }
    }

    class Minus : AbstractCalculator(), ICalculator {
        override fun calculate(exp: String): Int {
            val arrayInt = split(exp,"-")
            return arrayInt[0]-arrayInt[1]
        }
    }
    @Test
    fun test01() {
        val exp = "2+8"
        val plus = Plus()
        val result = plus.calculate(exp)
        println("2+8=$result")

        val exp2 = "8-2"
        val minus = Minus()
        val result2 = minus.calculate(exp2)
        println("8-2=$result2")
    }
}