package com.itlong.datastructure.hashmap

class UserBean(val name: String) {
    override fun hashCode(): Int {
        return name.length
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            println("同一个地址")
            return true
        }
        if (other == null) {
            println("对象为空")
            return false
        }
        if (javaClass != other.javaClass) {
            println("不是同一个类")
            return false
        }
        val that = other as UserBean
        return name.equals(that.name, ignoreCase = true)
    }
}