package com.linus.commonlib.schedule

import java.lang.Exception
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Schedule : ISchedule {
    private var scheduleObservers = ArrayList<ScheduleObserver>()
    private val scheduledExecutorService by lazy {
        Executors.newScheduledThreadPool(1) { r ->
            val thread = Thread(r)
            thread.name = "ITL_SCHEDULE_POOL"
            thread
        }
    }

    private val cacheThreadPool by lazy {
        Executors.newCachedThreadPool { r ->
            val thread = Thread(r)
            thread.name = "ITL_CACHE_POOL"
            thread
        }
    }

    private var start = false
    companion object {
        private val INSTANCE = Schedule()
        @Synchronized
        fun getInstance(): Schedule {
            return Schedule.INSTANCE
        }
    }

    override fun addObserver(observer: ScheduleObserver) {
        scheduleObservers.add(observer)
    }

    override fun removeObserver(observer: ScheduleObserver) {
        observer.onRemoved()
        scheduleObservers.remove(observer)
    }

    override fun removeAllObservers() {
        for (observer in scheduleObservers) {
            observer.onRemoved()
        }
        scheduleObservers.clear()
    }

    private fun notifyObservers() {
        for (observer in scheduleObservers) {
            try {
                cacheThreadPool.execute(observer)
            } catch (exception: Exception) {
                observer.onError(exception)
            }
        }
    }

    override fun start(initialDelay: Long, period: Long, unit: TimeUnit) {
        if (start) return
        start = true
        scheduledExecutorService.scheduleAtFixedRate({ notifyObservers() }, initialDelay, period, unit) //缺点，所有的观察者都是在同一个时间唤醒
    }

    override fun start() {
        start(10, 10, TimeUnit.MINUTES)
    }

    override fun stop() {
        start = false
        scheduledExecutorService.shutdown()
    }

    override fun isStart() = start
}