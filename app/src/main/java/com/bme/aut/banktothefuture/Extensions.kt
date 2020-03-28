package com.bme.aut.banktothefuture

import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams

fun View?.setMargin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) =
    this?.updateLayoutParams<ViewGroup.MarginLayoutParams> {
        left?.let { leftMargin = it }
        top?.let { topMargin = it }
        right?.let { rightMargin = it }
        bottom?.let { bottomMargin = it }
    }

fun View?.setSizeExt(height: Int? = null, width: Int? = null) {
    this?.let { view ->

        height?.let {
            val params = view.layoutParams
            params.height = it
            view.setLayoutParams(params)
        }

        width?.let {
            val params = view.layoutParams
            params.width = it
            view.setLayoutParams(params)
        }
    }
}

fun AppCompatActivity?.setStatusbarColor(color: Int, withDarkText: Boolean = false) {
    this?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = it.window

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            if (withDarkText) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }

            window.statusBarColor = ContextCompat.getColor(it, color)
        }
    }
}