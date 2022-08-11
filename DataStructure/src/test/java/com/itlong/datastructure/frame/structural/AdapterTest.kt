package com.itlong.datastructure.frame.structural

import org.junit.Test

// 适配器模式
// 配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的
// 类的兼容性问题。主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。

// 类适配器
// 核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口是Targetable，通过Adapter类，
// 将Source的功能扩展到Targetable里.这样Targetable接口的实现类就具有了Source类的功能
open class TwoPinSocket {
    fun connectTwoPin() {
        println("连接双脚插座")
    }
}

interface SocketAdapter {
    fun connectTwoPin()
    fun connectThreePin()
}

class SocketAdapterImpl : SocketAdapter, TwoPinSocket() {
    override fun connectThreePin() {
        println("连接三脚插座")
    }
}

// 对象适配器
// 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，而是持有Source类
// 的实例，以达到解决兼容性的问题。
class SocketWrapper(private val socket: TwoPinSocket) : SocketAdapter {
    override fun connectTwoPin() {
        socket.connectTwoPin()
    }

    override fun connectThreePin() {
        println("连接三脚插座2")
    }
}

interface Sourceable {
    fun method1()
    fun method2()
}

// 接口适配器模式
// 第三种适配器模式是接口的适配器模式，接口的适配器是这样的：有时我们写的一个接口中有多个抽象
//方法，当我们写该接口的实现类时，必须实现该接口的所有方法，这明显有时比较浪费，因为并不是所
//有的方法都是我们需要的，有时只需要某一些，此处为了解决这个问题，我们引入了接口的适配器模
//式，借助于一个抽象类，该抽象类实现了该接口，实现了所有的方法，而我们不和原始的接口打交道，
//只和该抽象类取得联系，所以我们写一个类，继承该抽象类，重写我们需要的方法就行。
abstract class Wrapper : Sourceable {
    override fun method1() {
    }

    override fun method2() {
    }
}

class SourceSub1 : Wrapper() {
    override fun method1() {
        println("Sub1 实现方法1")
    }
}

class SourceSub2 : Wrapper() {
    override fun method2() {
        println("Sub2 实现方法2")
    }
}

class AdapterTest {
    @Test
    fun test01() {
        val socketAdapter = SocketAdapterImpl()
        socketAdapter.connectTwoPin()
        socketAdapter.connectThreePin()
    }

    @Test
    fun test02() {
        val socket = TwoPinSocket()
        val socketWrapper = SocketWrapper(socket)
        socketWrapper.connectTwoPin()
        socketWrapper.connectThreePin()
    }

    @Test
    fun test03() {
        val sourceSub1 = SourceSub1()
        sourceSub1.method1()
        sourceSub1.method2()
        val sourceSub2 = SourceSub2()
        sourceSub2.method1()
        sourceSub2.method2()
    }
}