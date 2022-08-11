package com.itlong.datastructure.frame.structural

import org.junit.Test

// 桥接模式
// 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现
//化解耦，使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时
//候，在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一
//接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了。
interface Driver {
    fun connect()
}

class OracleDriver : Driver {
    override fun connect() {
        println("连接 Oracle 数据库")
    }
}

class MySqlDriver : Driver {
    override fun connect() {
        println("连接 MySql 数据库")
    }
}

abstract class DriverManager {
    var driver: Driver? = null
    open fun connect() {
        driver?.connect()
    }
}

class MyDriverManager : DriverManager() {
    override fun connect() {
        driver?.connect()
    }
}
class BridgeTest {
    @Test
    fun test() {
        val driverManager1 = MyDriverManager()
        driverManager1.driver = MySqlDriver()
        driverManager1.connect()

        val driverManager2 = MyDriverManager()
        driverManager2.driver = OracleDriver()
        driverManager2.connect()
    }
}