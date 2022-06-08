package com.linus.commonlib.observer

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class TestDemo {
    @Test
    fun test01() {
        Observable.just(1, 3, 4, 5, 6, 7)
            .filter(Predicate {
                return@Predicate it % 2 == 0
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                println("test01 it->$it")
            }
    }
}