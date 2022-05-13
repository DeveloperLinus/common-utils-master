package com.linus.commonlib.schedule

import java.util.concurrent.TimeUnit

interface ISchedule {
    fun addObserver(observer: ScheduleObserver)

    fun removeObserver(observer: ScheduleObserver)

    fun removeAllObservers()

    // 启动定时任务
    fun start(initialDelay: Long, period: Long, unit: TimeUnit)

    fun start()

    fun stop()

    fun isStart(): Boolean
}