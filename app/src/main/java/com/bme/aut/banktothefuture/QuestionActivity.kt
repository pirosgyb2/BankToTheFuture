package com.bme.aut.banktothefuture

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.banktothefuture.box.BoxActivity
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

        sendButton.setOnClickListener{
            val myIntent = Intent(this, BoxActivity::class.java)
            startActivity(myIntent)
        }

        init()
    }

    private fun init() {
        setStatusbarColor(R.color.colorGreyMid)
        backIcon?.setOnClickListener {
            val intent =
                Intent(this, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
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