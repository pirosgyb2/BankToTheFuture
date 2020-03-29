package com.bme.aut.banktothefuture

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    var questionNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        intent.extras?.getString("questionNumber")?.let {
            try {
                questionNumber = it.toInt()
            } catch (e: Exception) {
                Log.e("HIBA", "Scanned value: $it")
            }
        }

        init()
    }

    private fun init() {
        backIcon?.setOnClickListener {
            onBackPressed()
        }

        when (questionNumber) {
            1 -> {
                question?.text =
                    "sdkfsdfks sldkjs ldf lskfj dlsjf sdlf lskdfj sldfkj  sldfjsldfjsldkfjl kslfdkj sldf sldfkj lsdfj slk  ?"
                answerA.setup("A", "Egy almafa")
                answerB.setup("B", "Két kiskutya")
                answerC.setup("C", "Három katica")
                answerD.setup("D", "Ennyi lába van")
            }

            2 -> {

                question?.text =
                    "sdkfsdfks sldkjs ldf lskfj dlsjf sdlf lskdfj sldfkj  sldfjsldfjsldkfjl kslfdkj sldf sldfkj lsdfj slk  ?"
                answerA.setup("A", "Egy almafa")
                answerB.setup("B", "Két kiskutya")
                answerC.setup("C", "Három katica")
                answerD.setup("D", "Ennyi lába van")
            }

            3 -> {

                question?.text =
                    "sdkfsdfks sldkjs ldf lskfj dlsjf sdlf lskdfj sldfkj  sldfjsldfjsldkfjl kslfdkj sldf sldfkj lsdfj slk  ?"
                answerA.setup("A", "Egy almafa")
                answerB.setup("B", "Két kiskutya")
                answerC.setup("C", "Három katica")
                answerD.setup("D", "Ennyi lába van")
            }
            else -> {

                question?.text =
                    "sdkfsdfks sldkjs ldf lskfj dlsjf sdlf lskdfj sldfkj  sldfjsldfjsldkfjl kslfdkj sldf sldfkj lsdfj slk  ?"
                answerA.setup("A", "Egy almafa")
                answerB.setup("B", "Két kiskutya")
                answerC.setup("C", "Három katica")
                answerD.setup("D", "Ennyi lába van")
            }
        }
    }
}