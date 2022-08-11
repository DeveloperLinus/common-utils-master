package com.itlong.datastructure.frame.relation.twoClass

import org.junit.Test

// 观察者模式
// 包括这个模式在内的接下来的四个模式，都是类和类之间的关系，不涉及到继承，学的时候应该 记得归
// 纳，记得本文最开始的那个图。观察者模式很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博
// 客或wiki时，经常会看到RSS图标，就这的意思是，当你订阅了该文章，如果后续有更新，会及时通知
// 你。其实，简单来讲就一句话：当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变
// 化！对象之间是一种一对多的关系。
class ObserverTest {
    interface Observer {
        fun update(msg: String)
    }

    class XiaoMinObserver : Observer {
        override fun update(msg: String) {
            println("小明接收到消息了->$msg")
        }
    }

    class XiaoHongObserver : Observer {
        override fun update(msg: String) {
            println("小红接收到消息了->$msg")
        }
    }

    interface Subject {
        fun add(observer: Observer)

        fun remove(observer: Observer)

        fun operation()

        fun notifyObservers(msg: String)
    }

    abstract class AbstractSubject : Subject {
        private val observers = ArrayList<Observer>()
        override fun add(observer: Observer) {
            observers.add(observer)
        }

        override fun remove(observer: Observer) {
            observers.remove(observer)
        }

        override fun notifyObservers(msg: String) {
            for (observer in observers) {
                observer.update(msg)
            }
        }
    }

    class MySubject : AbstractSubject() {
        override fun operation() {
            println("打开文件")
            notifyObservers("打开文件")
        }
    }

    @Test
    fun test() {
        val mySubject = MySubject()
        mySubject.add(XiaoMinObserver())
        mySubject.add(XiaoHongObserver())
        mySubject.operation()
    }
}