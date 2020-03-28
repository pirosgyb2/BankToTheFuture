package com.bme.aut.banktothefuture.Box

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.banktothefuture.MainActivity
import com.bme.aut.banktothefuture.R

import kotlinx.android.synthetic.main.activity_box.*

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

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val boxBtn1 = findViewById<View>(R.id.box1) as ImageView
        boxBtn1.setOnClickListener {

            val messageFragment = MessageFragment()
            messageFragment.isCancelable = false

            val bundle = Bundle()
            bundle.putString(KEY_MSG, "500 aranypénzt nyertél!")
            messageFragment.arguments = bundle

            messageFragment.show(supportFragmentManager,
                "MessageFragment")
        }

        val boxBtn2 = findViewById<View>(R.id.box2) as ImageView
        boxBtn2.setOnClickListener {
            val messageFragment = MessageFragment()
            messageFragment.isCancelable = false

            val bundle = Bundle()
            bundle.putString(KEY_MSG, "300 aranypénzt nyertél!")
            messageFragment.arguments = bundle

            messageFragment.show(supportFragmentManager,
                "MessageFragment")
        }

        val boxBtn3 = findViewById<View>(R.id.box3) as ImageView
        boxBtn3.setOnClickListener {
            val messageFragment = MessageFragment()
            messageFragment.isCancelable = false

            val bundle = Bundle()
            bundle.putString(KEY_MSG, "10 aranypénzt nyertél!")
            messageFragment.arguments = bundle

            messageFragment.show(supportFragmentManager,
                "MessageFragment")
        }
    }

}
