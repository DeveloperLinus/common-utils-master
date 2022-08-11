package com.itlong.storageapp

import android.os.Environment
import android.util.Log
import com.itlong.storageapp.databinding.ActivityMainBinding
import com.linus.commonlib.ui.BaseBindingActivity
import java.io.File

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        binding.btnPrintFilePath.setOnClickListener {
            val publicPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
            val privatePath = getExternalFilesDir(Environment. DIRECTORY_DOWNLOADS).toString()
            Log.d("huqinghui", "publicPath->$publicPath privatePath->$privatePath") // publicPath->/storage/emulated/0/Download privatePath->/storage/emulated/0/Android/data/com.itlong.storageapp/files/Download
        }

        binding.btnFilesTraverse.setOnClickListener {
            val path = Environment.getExternalStorageDirectory().absolutePath +  File.separator + "itlong"
            Log.d("huqinghui", "path->$path")
            val fileNames = mutableListOf<String>()
            val fileTree = File(path).walk()
            fileTree.maxDepth(2)
                .filter { it.isFile }
//                .filter { it.extension == "txt" }
                .filter { it.extension in listOf("txt", "log") }
                .forEach {
                    fileNames.add(it.name)
                }
            for (fileName in fileNames) {
                Log.d("huqinghui", "fileName->$fileName")
            }
        }
    }
}