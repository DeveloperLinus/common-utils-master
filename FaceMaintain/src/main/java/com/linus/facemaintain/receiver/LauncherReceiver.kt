package com.linus.facemaintain.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.linus.facemaintain.service.FaceServiceProxy

class LauncherReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i("huqinghui", "onReceive() called with: context = [$context], intent = [$intent]收到开机广播")
        context.startService( Intent(context, FaceServiceProxy::class.java))
    }
}