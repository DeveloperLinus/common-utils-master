package com.linus.common.kotlin.proxyInterface

import org.junit.Test

class ProxyInterfaceTest {
    @Test
    fun test() {
        val eagle = WildFowl("老鹰", Bird.MALE, BehaviorFly())
        println(eagle.fly())
        val ostrich = WildFowl("鸵鸟", Bird.MALE, BehaviorRun())
        println(ostrich.run())
    }
}