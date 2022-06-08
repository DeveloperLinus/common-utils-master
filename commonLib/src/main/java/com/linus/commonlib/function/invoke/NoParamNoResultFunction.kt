package com.linus.commonlib.function.invoke

abstract class NoParamNoResultFunction(name: String?) : Function(name!!) {
    abstract fun onInvoke()
}