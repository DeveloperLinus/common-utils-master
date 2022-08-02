package com.linus.common.kotlin.set

import org.junit.Test

class SetDemoTest {
    @Test
    fun testMap() {
        val map = mapOf(0 to  "aa", 1 to "bb", 2 to "cc")
        map.forEach { (t, u) ->
            println("key->$t value->$u")
        }
        val map2 = mapOf(Pair(0, "aa"), Pair(1, "bb"), Pair(2, "cc"))
        for (item in map2) {
            println("key->${item.key} value->${item.value}")
        }
    }

    @Test
    fun testList() {
        val list = listOf("aa", "bb", "cc", "dd")
        for (index in list.indices) {
            println("index->$index value->${list[index]}")
        }
    }

    @Test
    fun testSet() {
        val set = setOf("AA", "BB", "CC", "DD", "BB")
        println("size->${set.size}") // size->4
        set.forEach {
            println("item->$it")
        }
        val set2 = mutableSetOf("aa", "bb", "cc", "dd")
        set2.add("gg")
        set2.add("ee")
        set2.add("ff")
        val iterator = set2.iterator()
        while (iterator.hasNext()) {
           val item =  iterator.next()
            println("item->$item")
        }
        set2.forEachIndexed { index, s ->
            println("index->$index s->$s")
        }
    }
}