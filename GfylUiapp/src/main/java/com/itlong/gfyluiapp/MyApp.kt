package com.itlong.gfyluiapp

import android.app.Application
import android.graphics.Typeface

class MyApp : Application() {
    companion object {
        @JvmField
        var typeFace : Typeface? = null
    }
    override fun onCreate() {
        super.onCreate()
        typeFace = Typeface.createFromAsset(assets, "fonts/SourceHanSansCNBold.otf")
    }
}