package com.linus.common.kotlin.abstract

class Goose(name: String = "鹅", sex: Int = Bird.MALE) : Bird(name, sex) , Behavior{
    override fun fly(): String {
        return "鹅能飞一点点，但飞不高，也飞不远"
    }

    override fun swim(): String {
        return "鹅，鹅，鹅，曲项向天歌"
    }

    override fun run(): String {
        return super.run()
    }

    override var skilledSports: String = "游泳"
}