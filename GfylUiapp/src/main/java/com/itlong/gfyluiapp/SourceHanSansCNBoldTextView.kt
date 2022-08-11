package com.itlong.gfyluiapp

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet


class SourceHanSansCNBoldTextView : androidx.appcompat.widget.AppCompatTextView {
    var fongUrl = "fonts/SourceHanSansCNBold.otf"

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defSyle: Int) : super(context, attrs, defSyle) {
        init(context)
    }

    /***
     * 设置字体
     *
     * @return
     */
    private fun init(context: Context) {
//        使用该方式首次启动耗时483 ms，后面启动耗时30ms内
        setTypeface(setFont(fongUrl, context))
//        typeface = MyApp.typeFace  // 首次启动在333 ms，后面启动在30ms内
    }

    fun setFont(ttf: String?, context: Context): Typeface {
        return Typeface.createFromAsset(context.assets, ttf)
    }
}