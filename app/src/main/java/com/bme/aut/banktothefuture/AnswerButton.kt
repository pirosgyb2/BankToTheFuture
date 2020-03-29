package com.bme.aut.banktothefuture

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.itemview_answer_button.view.*

class AnswerButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    var chosen = false

    init {
        View.inflate(context, R.layout.itemview_answer_button, this)
    }

    fun setup(signLetter: String, text: String) {
        sign?.text = signLetter
        answer?.text = text

        this.setOnClickListener {
            changeColor()
        }
    }

    fun changeColor() {
        TransitionManager.beginDelayedTransition(rootConstraintLayout)

        rootConstraintLayout?.post {
            if (chosen) {
                rootConstraintLayout?.background =
                    ContextCompat.getDrawable(context, R.drawable.answer_unselected)
                answer?.setTextColor(getColor(R.color.colorGreyMid))
                sign?.setTextColor(getColor(R.color.colorWhite))
                cancel?.visibility = View.GONE
                chosen = false
            } else {
                rootConstraintLayout?.background =
                    ContextCompat.getDrawable(context, R.drawable.answer_selected)
                answer?.setTextColor(getColor(R.color.colorWhite))
                sign?.setTextColor(getColor(R.color.cink))
                cancel?.visibility = View.VISIBLE
                chosen = true
            }
        }
    }

    private fun getColor(colorId: Int): Int {
        return ContextCompat.getColor(context, colorId)
    }
}
