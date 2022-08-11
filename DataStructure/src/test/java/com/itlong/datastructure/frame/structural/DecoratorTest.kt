package com.itlong.datastructure.frame.structural

import org.junit.Test

// 装饰模式
// 顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实
// 现同一个接口，装饰对象持有被装饰对象的实例

// 装饰器模式的应用场景：
// 1、需要扩展一个类的功能。
// 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不
// 能动态增删。）
// 缺点：产生过多相似的对象，不易排错！
interface Decorator {
    fun method()
}

class MyDecorator : Decorator {
    override fun method() {
        println("装西瓜到盒子内")
    }
}

class DecoratorImpl(private var decorator: Decorator) : Decorator {
    override fun method() {
        println("打开盒子")
        decorator.method()
        println("关闭盒子")
    }
}
class DecoratorTest {
    @Test
    fun test() {
        val decorator = MyDecorator()
        val decoratorImpl = DecoratorImpl(decorator)
        decoratorImpl.method()
    }
}