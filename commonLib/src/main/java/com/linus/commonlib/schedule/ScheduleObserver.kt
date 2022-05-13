package com.linus.commonlib.schedule

import java.lang.Exception

interface ScheduleObserver : Runnable {
    fun onError(exception: Exception)

    fun onRemoved()
}