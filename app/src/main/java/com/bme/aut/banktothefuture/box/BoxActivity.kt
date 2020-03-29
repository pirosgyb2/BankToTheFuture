package com.bme.aut.banktothefuture.box

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.banktothefuture.MainActivity
import com.bme.aut.banktothefuture.R

class BoxActivity : AppCompatActivity(), OnMessageFragmentAnswer {

    override fun onSelected() {
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }

    companion object {
        val KEY_MSG = "KEY_MSG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box)

        val boxBtn1 = findViewById<View>(R.id.box1) as ImageView
        val boxBtn2 = findViewById<View>(R.id.box2) as ImageView
        val boxBtn3 = findViewById<View>(R.id.box3) as ImageView


        boxBtn1.setOnClickListener {
            createDialog("500")
            sendingMoneyToMainActivity(500)
        }

        boxBtn2.setOnClickListener {
            createDialog("400")
            sendingMoneyToMainActivity(400)
        }

        boxBtn3.setOnClickListener {
            createDialog("10")
            sendingMoneyToMainActivity(10)
        }
    }

    private fun createDialog(string: String) {
        val messageFragment = MessageFragment()
        messageFragment.isCancelable = false

        val bundle = Bundle()
        bundle.putString(KEY_MSG, "$string pengőt nyertél!")
        messageFragment.arguments = bundle

        messageFragment.show(
            supportFragmentManager,
            "MessageFragment"
        )
    }

    private fun sendingMoneyToMainActivity(money: Int) {
        MainActivity.money += money
        val i = Intent(this@BoxActivity, MainActivity::class.java)
        //startActivity(i)
    }
}
