package com.linus.common.kotlin.proxyInterface

class BehaviorSwim : Behavior {
    override fun fly():String {
        return "BehaviorSwim fly"
    }
    override fun swim():String {
        return "BehaviorSwim swim"
    }
    override fun run():String {
        return "BehaviorSwim run"
    }
    override var skilledSports:String = "游泳"
}