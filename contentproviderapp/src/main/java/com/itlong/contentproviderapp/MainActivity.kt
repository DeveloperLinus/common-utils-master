package com.itlong.contentproviderapp

import android.util.Log
import com.itlong.contentproviderapp.databinding.ActivityMainBinding
import com.linus.commonlib.ui.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        binding.btnGetUserInfo.setOnClickListener {
            Thread {
                val userInfo = DataRepository.getInstance().getUser(this)
                Log.d("huqinghui", "userInfo->${userInfo.toString()}")
            }.start()
        }

        binding.btnInsertUserInfo.setOnClickListener {
            Thread {
                DataRepository.getInstance().saveUser(this, "小红")
                DataRepository.getInstance().saveUser(this, "小明")
                DataRepository.getInstance().saveUser(this, "小敏")
            }.start()
        }

        binding.btnGetAllUserInfo.setOnClickListener {
            Thread{
                DataRepository.getInstance().getAllUser(this)?.let {
                    for (user in it) {
                        Log.d("huqinghui", "user->$user")
                    }
                }
            }.start()
        }

        binding.btnDeleteAllUserInfo.setOnClickListener {
            Thread {
                val count = DataRepository.getInstance().deleteAll(this)
                Log.d("huqinghui", "count->$count")
            }.start()
        }
    }
}