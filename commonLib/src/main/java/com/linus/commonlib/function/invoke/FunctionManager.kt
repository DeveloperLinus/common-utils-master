package com.linus.commonlib.function.invoke


// 回调工厂
object FunctionManager {
    private val noParamNoResultFunctionMap  by lazy {
        mutableMapOf<String, NoParamNoResultFunction>()
    }
    private val noResultHaveParamFunctionMap by lazy {
        mutableMapOf<String, NoResultHaveParamFunction<Any>>()
    }

    /**
     * 添加回调
     *
     * @param function 回调方法
     * @return 当前对象
     */
//    fun addFunction(function: Function): FunctionManager? {
//        with(function) {
//            when(this) {
//                is NoParamNoResultFunction -> noParamNoResultFunctionMap.set(name)
//                is NoResultHaveParamFunction<*> -> noResultHaveParamFunctionMap.set(name)
//                else -> throw RuntimeException("not support other functions!")
//            }
//            this
//        }
//    }

    /**
     * 根据回调名称移除回调
     *
     * @param name 回调名称
     * @return 当前对象
     */
    fun removeFunction(name: String): FunctionManager? {
        noParamNoResultFunctionMap.remove(name)
        noResultHaveParamFunctionMap.remove(name)
        return this
    }

    /**
     * 移除所有回调
     *
     * @return 当前对象
     */
    fun removeAllFunction(): FunctionManager? {
        noParamNoResultFunctionMap!!.clear()
        noResultHaveParamFunctionMap!!.clear()
        return this
    }

    /**
     * 调用没有返回结果没有返回值的回调
     *
     * @param name 回调名称
     * @return 当前对象
     */
    fun invokeNoParamNoResult(name: String): FunctionManager? {
        val noParamNoResultFunction = noParamNoResultFunctionMap!![name]
        if (noParamNoResultFunction == null) {
            log("invokeNoParamNoResult: There is no function called $name")
            return this
        }
        noParamNoResultFunctionMap!![name]!!.onInvoke()
        return this
    }

//    fun <T> invokeNoResultHaveParam(name: String, data: T): FunctionManager? {
//        val noResultHaveParamFunction = noResultHaveParamFunctionMap[name]
//        if (noResultHaveParamFunction == null) {
//            log("invokeNoResultHaveParam: There is no function called $name")
//            return this
//        }
//        noResultHaveParamFunction.onInvoke(data)
//        return this
//    }
}