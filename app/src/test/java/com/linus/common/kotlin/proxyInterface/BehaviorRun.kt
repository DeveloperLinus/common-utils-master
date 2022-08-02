package com.linus.common.kotlin.proxyInterface

class BehaviorRun : Behavior {
    override fun fly():String {
        return "BehaviorRun fly..."
    }
    override fun swim():String {
        return "BehaviorRun swim"
    }
    override fun run():String {
        return super.run()
    }
    override var skilledSports:String = "奔跑"
}