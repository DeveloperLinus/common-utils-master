package com.linus.commonlib.schedule

import android.util.Log
import java.lang.Exception

class IncrementUpDataSchedule : ScheduleObserver{
    companion object {
        private var schedule = IncrementUpDataSchedule()
        fun addTask() {
            Log.d("huqinghui", "开始增量更新数据")
            if (schedule == null) {
                schedule = IncrementUpDataSchedule()
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
    }

    override fun onRemoved() {
        Log.d("huqinghui", "停止执行增量下载数据")
    }

    override fun run() {
        Log.d("huqinghui", "开始执行增量下载数据")
    }
}