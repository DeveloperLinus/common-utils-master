package com.itlong.gfyluiapp

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.util.DisplayMetrics
import com.itlong.gfyluiapp.databinding.ViewAuthFailResultBinding
import com.linus.commonlib.ui.BaseBindingActivity
import com.linus.commonlib.utils.log

class AuthFailResultAct : BaseBindingActivity<ViewAuthFailResultBinding>() {
    private var useTime = 0L
    private var startTime = 0L
    private var endTime = 0L

    override fun getLayoutId(): Int {
        return R.layout.view_auth_fail_result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        log("AuthFailResultAct onCreate")
        startTime = System.currentTimeMillis()
        super.onCreate(savedInstanceState)
    }

    override fun init() {
//        val width = getScreenWidth(this)
//        val height = getScreenHeight(this)
//        log("屏幕大小,width->$width, height->$height")
//
//        val xdpi = getXdpi(this)
//        val ydpi = getYdpi(this)
//        log("屏幕大小,xdpi->$xdpi, ydpi->$ydpi")
//
//
//        getScreenSizeOfDevice(this)
//
//
//        val fontFamily = binding.tvAuthFailResultMsg.typeface
//        log("fontFamily->${fontFamily}")
//        val map = getSSystemFontMap()
//        getKeyWithValue(map!!, fontFamily!!)?.forEach {
//            log("FontFamily->${it}")
//        }
    }

    override fun onResume() {
        super.onResume()
        log("AuthFailResultAct onResume")
        endTime = System.currentTimeMillis()
        useTime = endTime - startTime
        log("页面启动耗时->$useTime ms")
    }


    // 因为Android系统使用与上述五个名称相同的一种字体. (也许不同系统版本有一些差异,有关更多信息,请转到/system/etc/Fonts.xml)
    // system/etc/Fonts.xml
    private fun getSSystemFontMap(): Map<String, Typeface>? {
        var sSystemFontMap: Map<String, Typeface>? = null
        try {
            //Typeface typeface = Typeface.class.newInstance();
            val typeface: Typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            val f = Typeface::class.java.getDeclaredField("sSystemFontMap")
            f.isAccessible = true
            sSystemFontMap = f[typeface] as Map<String, Typeface>?
            for ((key, value) in sSystemFontMap!!) {
                log("FontMap  $key  --->  $value ")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sSystemFontMap
    }

    private fun getKeyWithValue(map: Map<String, Typeface>, value: Typeface): List<String>? {
        val set: Set<*> = map.entries
        val arr: MutableList<String> = ArrayList()
        for (obj in set) {
            val entry = obj as Map.Entry<String, Typeface>
            if (entry.value == value) {
                val str = entry.key
                arr.add(str)
            }
        }
        return arr
    }


    private fun getXdpi(instance: Activity): Float {
        val dm = DisplayMetrics()
        instance.windowManager.defaultDisplay.getMetrics(dm)
        log("density->${dm.density}, densityDpi->${dm.densityDpi}, scaledDensity->${dm.scaledDensity}")
        return dm.xdpi

    }


    private fun getYdpi(instance: Activity): Float {
        val dm = DisplayMetrics()
        instance.windowManager.defaultDisplay.getMetrics(dm)
        return dm.ydpi

    }


    /**
     * 获取屏幕宽度
     *
     * @param instance
     */
    private fun getScreenWidth(instance: Activity): Int {
        val dm = DisplayMetrics()
        instance.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

    /**
     * 获取屏幕高度
     *
     * @param instance
     */
    private fun getScreenHeight(instance: Activity): Int {
        val dm = DisplayMetrics()
        instance.windowManager.defaultDisplay.getMetrics(dm)
        return dm.heightPixels
    }


    private fun getScreenSizeOfDevice(instance: Activity) {

        val dm = DisplayMetrics()
        instance.windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels

        val height = dm.heightPixels

        val x = Math.pow(width.toDouble(), 2.0)

        val y = Math.pow(height.toDouble(), 2.0)

        val diagonal = Math.sqrt(x + y);

        val dens = dm.densityDpi

        val screenInches = diagonal / dens

        log("The screenInches $screenInches")

    }

}