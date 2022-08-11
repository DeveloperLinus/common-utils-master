package com.itlong.gfyluiapp

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

class PangMenZhengDaoTextView : androidx.appcompat.widget.AppCompatTextView {
    var fongUrl = "fonts/PangMenZhengDao.ttf"

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
        setTypeface(setFont(fongUrl, context))
    }

    fun setFont(ttf: String?, context: Context): Typeface {
        return Typeface.createFromAsset(context.assets, ttf)
    }
}