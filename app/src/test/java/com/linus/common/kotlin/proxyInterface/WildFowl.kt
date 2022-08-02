package com.linus.common.kotlin.proxyInterface

class WildFowl(name:String, sex:Int=MALE, behavior:Behavior) : Bird(name, sex), Behavior by behavior {
}