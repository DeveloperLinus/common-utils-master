package com.itlong.contentproviderapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    // 指定该数据库有哪些表，若需建立多张表，以逗号相隔开
    entities = [User::class],
    // 指定数据库版本号，后续数据库的升级正是依据版本号来判断的
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // 提供所有Dao，对一一对应的数据库表进行操作
    abstract fun getUserDao(): UserDao

    companion object {

        private const val DB_NAME = "content_provider_app.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}