package com.linus.common.kotlin.proxyInterface

class BehaviorFly : Behavior {
    override fun fly():String {
        return "BehaviorFly  fly..."
    }
    override fun swim():String {
        return "BehaviorFly  swim"
    }
    override fun run():String {
        return "BehaviorFly  run.."
    }
    override var skilledSports:String = "飞翔"
}