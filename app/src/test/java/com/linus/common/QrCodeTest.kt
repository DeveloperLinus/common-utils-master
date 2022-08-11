package com.linus.common

import org.junit.Test
import java.util.concurrent.ConcurrentHashMap

class QrCodeTest {
    private val taskList = ConcurrentHashMap<Long, String>()
    @Test
    fun test() {
        taskList[1000L] = "HUQINGHUI"
        taskList[12L] = "XIAOMIN"
        taskList[1000L] = "HUQINGHUI2"
        println("size->${taskList.size}")
        taskList.forEach {map->
            println("key->${map.key}, value->${map.value}")
        }
    }
}