package com.bme.aut.banktothefuture

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var statusBarHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        init()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun init() {
        backIcon?.setOnClickListener {
            onBackPressed()
        }

        answerA.setup("A", "Egy almafa")
        answerB.setup("B", "Két kiskutya")
        answerC.setup("C", "Három katica")
        answerD.setup("D", "Ennyi lába van")
    }
}