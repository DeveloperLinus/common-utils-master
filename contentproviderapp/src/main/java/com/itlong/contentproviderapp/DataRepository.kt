package com.itlong.contentproviderapp

import android.content.Context
import android.database.Cursor

class DataRepository{
    companion object {

        @Volatile
        private var instance: DataRepository? = null

        @Synchronized
        fun getInstance(): DataRepository {
            if (instance == null) {
                instance = DataRepository()
            }
            return instance!!
        }
    }

    /**
     * 查询用户信息
     */
    fun getUser(context: Context): User? {
        val userList = AppDatabase.getDatabase(context).getUserDao().getAll()
        if (userList.isNullOrEmpty()) {
            return null
        }

        return userList[0]
    }

    fun getAllUser(context: Context): List<User>? {
        return AppDatabase.getDatabase(context).getUserDao().getAll()
    }

    fun getAllUser2(context: Context): Cursor {
        return AppDatabase.getDatabase(context).getUserDao().getAll2()
    }

    fun deleteAll(context: Context): Int {
        return AppDatabase.getDatabase(context).getUserDao().deleteAll()
    }

    /**
     * 储存用户信息
     *
     * @param content 用户信息Bean Json
     */
    fun saveUser(context: Context, content: String) {
        val dao = AppDatabase.getDatabase(context).getUserDao()
        val user = User(content = content)
        dao.insert(user)
    }
}