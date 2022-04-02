package com.linus.commonlib.thread.pool

import java.util.concurrent.*

class CacheThreadPool {
    @Volatile
    private var mExecutors: ThreadPoolExecutor? = null

    private fun initThreadPoolExecutor() {
        if (mExecutors == null || mExecutors!!.isShutdown || mExecutors!!.isTerminated) {
            synchronized(CacheThreadPool::class.java) {
                if (mExecutors == null || mExecutors!!.isShutdown || mExecutors!!.isTerminated) {
                    val keepAliveTime = 60L
                    val unit = TimeUnit.MILLISECONDS
                    mExecutors = ThreadPoolExecutor(0, Int.MAX_VALUE, keepAliveTime, unit, SynchronousQueue())
                }
            }
        }
    }

    fun execute(task: Runnable?) {
        initThreadPoolExecutor()
        mExecutors!!.execute(task)
    }

    fun submit(task: Runnable?): Future<*> {
        initThreadPoolExecutor()
        return mExecutors!!.submit(task)
    }

    fun <T> submit(callable: Callable<T>): Future<T> {
        initThreadPoolExecutor()
        return mExecutors!!.submit(callable)
    }

    fun remove(task: Runnable?) {
        initThreadPoolExecutor()
        mExecutors!!.remove(task)
    }
}