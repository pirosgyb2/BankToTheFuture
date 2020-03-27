package com.bme.aut.banktothefuture

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

class UnscrollableScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ScrollView(context, attrs, defStyle) {

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }
}