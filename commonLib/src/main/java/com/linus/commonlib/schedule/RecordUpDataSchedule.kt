package com.linus.commonlib.schedule

import android.util.Log
import java.lang.Exception

class RecordUpDataSchedule : ScheduleObserver {
    companion object {
        private var schedule = RecordUpDataSchedule()
        fun addTask() {
            Log.d("huqinghui", "开始通行记录上传")
            if (schedule == null) {
                schedule = RecordUpDataSchedule()
            }
            Schedule.getInstance().addObserver(schedule)
        }

        fun removeTask() {
            Log.d("huqinghui", "停止增量更新数据")
            schedule?.run()
            Schedule.getInstance().removeObserver(schedule)
        }
    }
    override fun onError(exception: Exception) {
        Log.d("huqinghui", "error msg->${exception.message}")
    }

    override fun onRemoved() {
        Log.d("huqinghui", "停止执行通行记录上传")
    }

    override fun run() {
        Log.d("huqinghui", "执行通行记录上传")
    }
}