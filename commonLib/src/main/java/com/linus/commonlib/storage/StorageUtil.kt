package com.linus.commonlib.storage

import android.os.Environment

object StorageUtil {
    fun getPathA() : String{
        // 获得sd状态 ，可以判断sd是否可用 返回字符串
        return if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            // --->/storage/emulated/0/face1/data/com.linus.common
            Environment.getExternalStorageDirectory().absolutePath + "/face1/data/" + UiUtils.mContext?.packageName
        } else {
            "none"
        }
    }

    fun getPathB(): String {
        // --->/data/user/0/com.linus.common/files/face2/data/com.linus.common
        return UiUtils.mContext?.filesDir?.absolutePath.toString() + "/face2/data/" + UiUtils.mContext?.packageName
    }
}