package com.itlong.gfyluiapp

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 * @author   HuQingHui
 * @date     2022/8/8
 */
class ShowResultView(private var context: Context, private var showFl: FrameLayout) {
    private var showTime = 5000
    private var time: Long? = null
    private var showAuthFailViewHolder: ShowAuthResultViewHolder? = null
    private var onUserSelectFloorListener: OnUserSelectFloorListener? = null

    fun setOnUserSelectFloorListener(onUserSelectFloorListener: OnUserSelectFloorListener) {
        this.onUserSelectFloorListener = onUserSelectFloorListener
    }

    fun setShowTime(showTime: Int) {
        this.showTime = Math.max(5000, showTime)
    }


    private val disMissHandler = Handler()


    class DisMissR : Runnable {
        override fun run() {
        }
    }


    fun disMissAllView() {
        showFl.removeAllViews()
    }

    fun showDtInfoView(mode: Int, floorInfo: FloorInfo) {

    }

    fun showError(isBusy: Boolean, errorInfo: String, showTime: Int) {
//        showError(isBusy, null, errorInfo, showTime)
    }


    private fun getDtErrorViewHolder(): ShowAuthResultViewHolder? {
        if (showAuthFailViewHolder == null) {
            var resultView = LayoutInflater.from(context).inflate(R.layout.view_auth_result, null, false)
            showAuthFailViewHolder = ShowAuthResultViewHolder(resultView)
        }
        showAuthFailViewHolder?.ivAuthResultLogo?.setImageResource(R.mipmap.ic_exclam_logo_720_1280)
        return showAuthFailViewHolder
    }


    class ShowAuthResultViewHolder(view: View) : ShowResultViewHolder() {
        init {
            showView = view
            rlBgAuthResult = view.findViewById(R.id.rl_bg_auth_result)
            ivAuthResultRectangle = view.findViewById(R.id.iv_auth_result_rectangle)
            ivAuthResultCircle = view.findViewById(R.id.iv_auth_result_circle)
            ivAuthResultLogo = view.findViewById(R.id.iv_auth_result_logo)
            tvAuthResultTitle = view.findViewById(R.id.tv_auth_result_title)
            tvAuthResultSubTitle = view.findViewById(R.id.tv_auth_result_sub_title)
        }
    }

    open class ShowResultViewHolder {
        var showView: View? = null
        var rlBgAuthResult: FrameLayout? = null
        var ivAuthResultRectangle: ImageView? = null
        var ivAuthResultCircle: ImageView? = null
        var ivAuthResultLogo: ImageView? = null
        var tvAuthResultTitle: TextView? = null
        var tvAuthResultSubTitle: TextView? = null
    }
}