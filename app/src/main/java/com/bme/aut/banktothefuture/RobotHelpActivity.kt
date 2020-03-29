package com.bme.aut.banktothefuture

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_class.*

import kotlinx.android.synthetic.main.activity_robot_help.*
import kotlinx.android.synthetic.main.activity_robot_help.fab

class RobotHelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robot_help)

        fab.setOnClickListener { view ->
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

        answerA.setup("1","Mire jó ez az alkalmazás?")
        answerB.setup("2","Merre találom a mosdót?")
        answerC.setup("3","Miket nyerhetek?")
        answerD.setup("4","Ki vagy te?")

    }

}
