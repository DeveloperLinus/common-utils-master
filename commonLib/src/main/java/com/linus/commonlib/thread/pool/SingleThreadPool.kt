package com.linus.commonlib.thread.pool

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class SingleThreadPool {
    @Volatile
    private var mExecutor: ExecutorService? = null

    private fun initThreadPoolExecutor() {
        if (mExecutor == null || mExecutor!!.isShutdown || mExecutor!!.isTerminated) {
            synchronized(SingleThreadPool::class.java) {
                if (mExecutor == null || mExecutor!!.isShutdown || mExecutor!!.isTerminated) {
                    mExecutor = Executors.newSingleThreadExecutor()
                }
            }
        }
    }

    fun execute(task: Runnable?) {
        initThreadPoolExecutor()
        mExecutor!!.execute(task)
    }

    fun submit(task: Runnable?): Future<*> {
        initThreadPoolExecutor()
        return mExecutor!!.submit(task)
    }

    fun <T> submit(callable: Callable<T>): Future<T> {
        initThreadPoolExecutor()
        return mExecutor!!.submit(callable)
    }
}