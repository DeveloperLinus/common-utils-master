package com.itlong.datastructure.frame.structural

import org.junit.Test

// 外观模式
// 外观模式是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文
//件中，而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉 及到接口
class Cpu {
    fun startup() {
        println("CPU开始运行")
    }

    fun shutdown() {
        println("CPU停止运行")
    }
}

class Disk {
    fun startup() {
        println("磁盘开始准备完毕")
    }

    fun shutdown() {
        println("磁盘停止运行")
    }
}

class Memory {
    fun startup() {
        println("内存开始运行")
    }

    fun shutdown() {
        println("内存停止运行")
    }
}

// 如果我们没有Computer类，那么，CPU、Memory、Disk他们之间将会相互持有实例，产生关系，这样
//会造成严重的依赖，修改一个类，可能会带来其他类的修改，这不是我们想要看到的，有了Computer
//类，他们之间的关系被放在了Computer类里，这样就起到了解耦的作用，这，就是外观模式！
class Computer {
    private val cpu by lazy { Cpu() }
    private val memory by lazy { Memory() }
    private val disk by lazy { Disk() }

    fun startup() {
        println("电脑打开")
        cpu.startup()
        memory.startup()
        disk.startup()
    }

    fun shutdown() {
        println("电脑关闭")
        cpu.shutdown()
        memory.shutdown()
        disk.shutdown()
    }
}
class FacadeTest {
    @Test
    fun test() {
        val computer = Computer()
        computer.startup()
        computer.shutdown()
    }
}