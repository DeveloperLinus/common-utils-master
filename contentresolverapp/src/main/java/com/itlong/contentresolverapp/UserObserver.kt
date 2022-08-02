package com.itlong.contentresolverapp

import android.database.ContentObserver
import android.net.Uri
import android.os.Handler
import android.os.Message

class UserObserver(handler: Handler) : ContentObserver(handler) {
    private val mHandler = handler
    override fun onChange(selfChange: Boolean, uri: Uri?) {
        super.onChange(selfChange, uri)
        val message = Message.obtain()
        message.obj = uri
        mHandler.sendMessage(message)
    }
}