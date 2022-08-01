package com.linus.common.kotlin.abstract

interface Behavior {
    // 接口内部的方法默认就是抽象的，所以不加abstract也可以，当然open也可以不加
    open abstract fun fly(): String
    // 比如下面这个swim方法就没加关键字abstract，也无须在此处实现方法
    fun swim(): String
    fun run() : String {
        return "大多数鸟儿跑得并不像样，只有鸵鸟、鹧鸪等少数鸟类才擅长奔跑。"
    }
    var skilledSports: String
}