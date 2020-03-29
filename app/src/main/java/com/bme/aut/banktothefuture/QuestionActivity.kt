package com.bme.aut.banktothefuture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        init()
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