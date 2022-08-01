package com.linus.common.kotlin.classAndObject
// Kotlin叫枚举类，Java叫枚举类型
enum class SeasonType {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum class SeasonName (val seasonName:String) {
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天")
}