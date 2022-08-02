package com.itlong.contentproviderapp

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log
import java.lang.Exception

class UserProvider : ContentProvider() {
    //这里的AUTHORITY就是我们在AndroidManifest.xml中配置的authorities
    private val AUTHORITY = "com.itlong.contentproviderapp.userProvider"

    //匹配成功后的匹配码
    private val MATCH_CODE = 100

    //数据改变后指定通知的Uri
    private val NOTIFY_URI = Uri.parse("content://$AUTHORITY/userchange")
    private val uriMatcher by lazy {
        // 匹配不成功返回-1
        UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, "user", MATCH_CODE)
        }
    }
    override fun onCreate(): Boolean {
       return false
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val match = uriMatcher.match(uri)
        return if (match == MATCH_CODE) {
            DataRepository.getInstance().getAllUser2(App.context)
        } else {
            null
        }
    }

    override fun getType(p0: Uri): String? {
        return  null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        if (uriMatcher.match(uri) == MATCH_CODE) {
            try {
                val content = values?.getAsString("content")
                DataRepository.getInstance().saveUser(App.context, content = content!!)
                Log.d("huqinghui", "insert user->${content}")
                notifyChange()
            } catch (exception: Exception) {
                Log.d("huqinghui", "exception->${exception.message}")
            }
        }
//        Log.d("huqinghui", "正在执行耗时操作...")
//        Thread.sleep(20000)
//        Log.d("huqinghui", "耗时操作执行完毕...")
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        if (uriMatcher.match(uri) == MATCH_CODE) {
            val count = DataRepository.getInstance().deleteAll(App.context)
            notifyChange()
            return count
        }
        return 0
    }

    override fun update(uri: Uri, contentValues: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    private fun notifyChange() {
        App.context.contentResolver.notifyChange(NOTIFY_URI, null)
    }
}