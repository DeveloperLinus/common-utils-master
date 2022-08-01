package com.linus.common.kotlin.classAndObject

import org.junit.Test

class QianTaoClassTest {
    class Tree(var treeName: String) {
        // 嵌套类
        class Flower(var flowerName: String) {
            fun getName(): String {
//                return "这是${treeName}" // 找不到 红色，编译器报 Unresolved reference， Java的话，嵌套类可以访问外部类成员，Kotlin则不行
                return "这是一朵${flowerName}"
            }
        }

        // 嵌套类加inner，转换为内部类
        inner class Fruit(var fruitName: String) {
            fun getName() : String {
                return "这是$treeName 长出来的$fruitName" // 内部类可以访问外部类的成员
            }
        }
    }

    @Test
    fun test01() {
        val peachBlossom = Tree.Flower("桃花")
        println("${peachBlossom.getName()}") // 这是一朵桃花
        val peach = Tree("桃树").Fruit("桃子")
        println("${peach.getName()}") // 这是桃树 长出来的桃子
    }
}