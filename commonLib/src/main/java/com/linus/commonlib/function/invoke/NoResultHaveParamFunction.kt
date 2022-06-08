package com.linus.commonlib.function.invoke

abstract class NoResultHaveParamFunction<T>(name: String?) : Function(name!!) {
    abstract fun onInvoke(data: T)
}