package com.linus.commonlib.thread

import com.linus.commonlib.thread.pool.CacheThreadPool
import com.linus.commonlib.thread.pool.DefaultThreadPool
import com.linus.commonlib.thread.pool.SingleThreadPool

object ThreadPoolProxyFactory {
    @Volatile
    var defaultThreadPool: DefaultThreadPool? = null
        get() {
            if (field == null) {
                synchronized(ThreadPoolProxyFactory::class.java) {
                    if (field == null) {
                        field = DefaultThreadPool(4, 16)
                    }
                }
            }
            return field
        }
        private set

    @Volatile
    var cacheThreadPool: CacheThreadPool? = null
        get() {
            if (field == null) {
                synchronized(ThreadPoolProxyFactory::class.java) {
                    if (field == null) {
                        field = CacheThreadPool()
                    }
                }
            }
            return field
        }
        private set

    @Volatile
    var singleThreadPool: SingleThreadPool? = null
        get() {
            if (field == null) {
                synchronized(ThreadPoolProxyFactory::class.java) {
                    if (field == null) {
                        field = SingleThreadPool()
                    }
                }
            }
            return field
        }
        private set
}