package com.itlong.contentresolverapp

import android.annotation.SuppressLint
import android.content.ContentProviderOperation
import android.content.ContentValues
import android.net.Uri
import android.os.Handler
import android.os.Message
import android.util.Log
import com.itlong.contentresolverapp.databinding.ActivityMainBinding
import com.linus.commonlib.ui.BaseBindingActivity
import java.util.ArrayList

class MainActivity : BaseBindingActivity<ActivityMainBinding>(){
    private val AUTHORITY = "com.itlong.contentproviderapp.userProvider"
    private val USER_URI = Uri.parse("content://$AUTHORITY/user")
    //数据改变后指定通知的Uri
    private val NOTIFY_URI = Uri.parse("content://$AUTHORITY/userchange")
    private val userObserver by lazy {
        UserObserver(object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.d("huqinghui", "数据变化, uri->${msg.obj}")
                // TODO 数据发送变化，重新去数据库查询数据后刷新UI
            }
        })
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onResume() {
        super.onResume()
        contentResolver.registerContentObserver(NOTIFY_URI, true, userObserver)
    }

    override fun onPause() {
        super.onPause()
        contentResolver.unregisterContentObserver(userObserver)
    }

    @SuppressLint("Range")
    override fun init() {
        binding.btnGetAllUserInfo.setOnClickListener {
            contentResolver.query(USER_URI, null, null, null, null)?.let { cursor ->
                while (cursor.moveToNext()) {
                    val content = cursor.getString(cursor.getColumnIndex("content"))
                    Log.d("huqinghui", "contentResolver content->$content")
                }
                cursor.close()
            }
        }

        binding.btnDeleteAllUserInfo.setOnClickListener {
            val count = contentResolver.delete(USER_URI, null, null)
            Log.d("huqinghui", "contentResolver delete count->$count")
        }

        binding.btnInsertUserInfo.setOnClickListener {
            val contentValues = ContentValues()
            contentValues.put("content", "小李飞刀")
            contentResolver.insert(USER_URI, contentValues)
        }

        binding.btnAddUserInfoList.setOnClickListener {
            Thread{
                val xiaoming = ContentProviderOperation.newInsert(USER_URI).withValue("content", "小明2").build()
                val xiaomin = ContentProviderOperation.newInsert(USER_URI).withValue("content",  "小敏2").build()
                val xiaohong = ContentProviderOperation.newInsert(USER_URI).withValue("content", "小红2").build()
                var operations = ArrayList<ContentProviderOperation>()
                operations.add(xiaoming)
                operations.add(xiaomin)
                operations.add(xiaohong)
                contentResolver.applyBatch("com.itlong.contentproviderapp.userProvider", operations)
            }.start()
        }
    }
}




























