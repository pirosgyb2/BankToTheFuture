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
                    "Melyik uralkodónkhoz/fejedelemhez kötődik az a pénzfajta, amit közel 200 évig használtak a Közel-Keleten? És mi ez a pénztípus?"
                answerA.setup("A", "Mária Terézia, Tallér")
                answerB.setup("B", "Károly Róbert, Aranyforint")
                answerC.setup("C", "Hunyadi Mátyás, Ezüstdénár")
                answerD.setup("D", "II. Rákóczi Ferenc, Poltura")
            }

            2 -> {

                question?.text =
                    "Melyik uralkodónkhoz/fejedelemhez kötődik az a pénzfajta, amit közel 200 évig használtak a Közel-Keleten? És mi ez a pénztípus?"
                answerA.setup("A", "Mária Terézia, Tallér")
                answerB.setup("B", "Károly Róbert, Aranyforint")
                answerC.setup("C", "Hunyadi Mátyás, Ezüstdénár")
                answerD.setup("D", "II. Rákóczi Ferenc, Poltura")
            }

            3 -> {

                question?.text =
                    "Melyik uralkodónkhoz/fejedelemhez kötődik az a pénzfajta, amit közel 200 évig használtak a Közel-Keleten? És mi ez a pénztípus?"
                answerA.setup("A", "Mária Terézia, Tallér")
                answerB.setup("B", "Károly Róbert, Aranyforint")
                answerC.setup("C", "Hunyadi Mátyás, Ezüstdénár")
                answerD.setup("D", "II. Rákóczi Ferenc, Poltura")
            }
            else -> {

                question?.text =
                    "Melyik uralkodónkhoz/fejedelemhez kötődik az a pénzfajta, amit közel 200 évig használtak a Közel-Keleten? És mi ez a pénztípus?"
                answerA.setup("A", "Mária Terézia, Tallér")
                answerB.setup("B", "Károly Róbert, Aranyforint")
                answerC.setup("C", "Hunyadi Mátyás, Ezüstdénár")
                answerD.setup("D", "II. Rákóczi Ferenc, Poltura")
            }
        }
    }
}