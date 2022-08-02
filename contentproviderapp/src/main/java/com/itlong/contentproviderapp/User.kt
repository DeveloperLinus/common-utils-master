package com.itlong.contentproviderapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 该注解代表数据库一张表，tableName为该表名字，不设置则默认类名
// 注解必须有！！tableName可以不设置
@Entity(tableName = "User")
data class User(
    // 该标签指定该字段作为表的主键, 自增长。注解必须有！！
    @PrimaryKey val id: Int? = null,

    // 该注解设置当前属性在数据库表中的列名和类型，注解可以不设置，不设置默认列名和属性名相同
    @ColumnInfo(name = "content", typeAffinity = ColumnInfo.TEXT)
    var content: String?

    // 该标签用来告诉系统忽略该字段或者方法，顾名思义：不生成列 @Ignore
)