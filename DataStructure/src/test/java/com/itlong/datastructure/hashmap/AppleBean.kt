package com.itlong.datastructure.hashmap

class AppleBean(val price: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            println("同一个地址2")
            return true
        }
        if (other == null) {
            println("对象为空2")
            return false
        }
        if (javaClass != other.javaClass) {
            println("不是同一个类2")
            return false
        }
        val that = other as AppleBean
        return price == that.price
    }
}