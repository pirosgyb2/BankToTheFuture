package com.bme.aut.banktothefuture

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.itemview_floor.view.*

class FloorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    init {
        View.inflate(context, R.layout.itemview_floor, this)
    }

    fun bind(number: Int) {
        if (number == 0) {
            title?.text = "Földszint"
        } else {
            title?.text = "$number. szint"
        }

    }
}