package com.itlong.datastructure.frame.relation.twoClass

class IteratorTest {
    interface Collection {
        operator fun iterator(): Iterator?

        /*取得集合元素*/
        operator fun get(i: Int): Any?

        /*取得集合大小*/
        fun size(): Int
    }

    interface Iterator {
        //前移
        fun previous(): Any?

        //后移
        operator fun next(): Any?
        operator fun hasNext(): Boolean

        //取得第一个元素
        fun first(): Any?
    }

    class MyIterator(private val collection:Collection) :  Iterator {
        override fun previous(): Any? {
            TODO("Not yet implemented")
        }

        override fun next(): Any? {
            TODO("Not yet implemented")
        }

        override fun hasNext(): Boolean {
            TODO("Not yet implemented")
        }

        override fun first(): Any? {
            TODO("Not yet implemented")
        }
    }
}