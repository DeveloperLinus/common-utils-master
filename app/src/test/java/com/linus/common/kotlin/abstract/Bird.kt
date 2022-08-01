package com.linus.common.kotlin.abstract

open class Bird (var name:String, val sex:Int = MALE) {
//public var sexName:String
    var sexName:String
    init {
        sexName = getSexName(sex)
    }
//open private fun getSexName(sex:Int):String {
    open protected fun getSexName(sex:Int):String {
        return if (sex == MALE) "公" else "母"
    }
    fun getDesc(tag:String):String {
        return "欢迎来到$tag:这只$name 是$sexName 的"
    }
    companion object BirdStatic{
        val MALE = 0
        val FEMALE = 1
        val UNKNOWN = -1
        fun judgeSex(sexName:String):Int {
            var sex:Int = when (sexName) {
                "","لᵜ" -> MALE
                "ྮ","ᵡ" -> FEMALE
                else -> UNKNOWN
            }
            return sex
        }
    }
}