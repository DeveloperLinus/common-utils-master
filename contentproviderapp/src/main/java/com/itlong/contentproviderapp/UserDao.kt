package com.itlong.contentproviderapp

import android.database.Cursor
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE content LIKE :content LIMIT 1")
    fun findByContent(content: String): User

    @Query("SELECT * FROM User")
    fun getAll2() : Cursor

    @Query("SELECT * FROM User WHERE content Like :content LIMIT 1")
    fun queryUserByContent(content: String): Cursor

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM User")
    fun deleteAll(): Int

    @Query("SELECT * FROM User  LIMIT 1")
    fun findFirst() : User

    @Update
    fun update(user: User)
}