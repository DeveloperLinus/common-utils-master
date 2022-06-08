package com.linus.commonlib.observer

import android.annotation.SuppressLint
import com.linus.commonlib.bean.DeviceInfo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers

class ObserverTest {
    companion object {
        @SuppressLint("CheckResult")
        @JvmStatic
        fun test01(deviceId: String, ip: String) {
            Observable.just(DeviceInfo(deviceId, ip))
                .filter(Predicate {
                    return@Predicate ip == "192.168.100.1" // 线下才执行
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    println("deviceId->$deviceId")
                }
        }

        private fun getNetworkData(deviceId: String) : String{
            return deviceId + "ccccccc"
        }
    }

}
