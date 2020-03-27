package com.bme.aut.banktothefuture

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_qr.*

class MainActivity : AppCompatActivity() {

    var screenHeight = 0
    var actualFloor = 2
    var topFloorNumber = 2
    var bottomFloowNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels

        init()

        camera.setOnClickListener {
            val myIntent = Intent(this, QrActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onResume() {
        super.onResume()

        floor0?.let {
            rootScrollView?.smoothScrollTo(0, it.top)
        }
    }

    private fun init() {
        val params0 = floor0?.layoutParams
        params0?.height = screenHeight
        floor0?.setLayoutParams(params0)
        floor0?.bind(0)

        val params1 = floor1?.layoutParams
        params1?.height = screenHeight
        floor1?.setLayoutParams(params1)
        floor1?.bind(1)

        val params2 = floor2?.layoutParams
        params2?.height = screenHeight
        floor2?.setLayoutParams(params2)
        floor2?.bind(2)

        up.setOnClickListener { scrollUp() }
        down.setOnClickListener { scrollDown() }
    }


    private fun scrollUp() {
        if (actualFloor < topFloorNumber) {

            when (actualFloor) {
                0 -> floor1?.let { scrollTo(it.top) }
                1 -> floor2?.let { scrollTo(it.top) }
            }

            actualFloor++
        }
    }

    private fun scrollDown() {
        if (actualFloor > bottomFloowNumber) {

            when (actualFloor) {
                2 -> floor1?.let { scrollTo(it.top) }
                1 -> floor0?.let { scrollTo(it.top) }
            }

            actualFloor--
        }
    }

    private fun scrollTo(positionToScroll: Int) {
        ObjectAnimator.ofInt(rootScrollView, "scrollY", positionToScroll).setDuration(600L).start();
    }
}
