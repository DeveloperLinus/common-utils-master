package com.linus.commonlib.thread.pool

import java.util.concurrent.*

class DefaultThreadPool(private val mCoreSize: Int, private val mMaximumSize: Int) {
    @Volatile
    private var mExecutor: ThreadPoolExecutor? = null

    private fun initThreadPoolExecutor() {
        if (mExecutor == null || mExecutor!!.isShutdown || mExecutor!!.isTerminated) {
            synchronized(DefaultThreadPool::class.java) {
                if (mExecutor == null || mExecutor!!.isShutdown || mExecutor!!.isTerminated) {
                    val keepAliveTime = 5000L
                    val unit = TimeUnit.MILLISECONDS
                    val blockingQueue: BlockingQueue<Runnable> = LinkedBlockingDeque()
                    val threadFactory = Executors.defaultThreadFactory()
                    val handler: RejectedExecutionHandler = ThreadPoolExecutor.DiscardPolicy()
                    mExecutor = ThreadPoolExecutor(mCoreSize, mMaximumSize, keepAliveTime, unit, blockingQueue, threadFactory, handler)
                }
            }
        }
    }

    fun execute(task: Runnable?) {
        initThreadPoolExecutor()
        mExecutor!!.execute(task)
    }

    fun submit(task: Runnable?) : Future<*> {
        initThreadPoolExecutor()
        return mExecutor!!.submit(task)
    }

    fun <T> submit(callable: Callable<T>): Future<T> {
        initThreadPoolExecutor()
        return mExecutor!!.submit(callable)
    }

    fun remove(task: Runnable?) {
        initThreadPoolExecutor()
        mExecutor!!.remove(task)
    }
}