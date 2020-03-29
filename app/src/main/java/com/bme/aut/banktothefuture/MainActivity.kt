package com.bme.aut.banktothefuture

import android.Manifest
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.livinglifetechway.quickpermissions.annotations.WithPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var money = 500
    }

    private var screenHeight = 0
    private var statusBarHeight: Int = 0

    private var actualFloor = 0
    private var topFloorNumber = 2
    private var bottomFloowNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels

        initScrollView()
        init()

        camera.setOnClickListener {
            val myIntent = Intent(this, QrActivity::class.java)
            startActivity(myIntent)
        }

        getCameraPermission()
    }

    override fun onResume() {
        super.onResume()
        setTransaparentStatusbar()
        moneyCountTextView?.text = money.toString()
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

        robot?.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }

        arrow?.setOnClickListener {
            val intent = Intent(this, ArrowsActivity::class.java)
            startActivity(intent)
        }

        gifts?.setOnClickListener {
            val intent = Intent(this, GiftsActivity::class.java)
            startActivity(intent)
        }
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

    private fun initScrollView() {
        rootScrollView?.post { rootScrollView?.smoothScrollTo(0, 5000) }
    }

    private fun scrollTo(positionToScroll: Int) {
        ObjectAnimator.ofInt(rootScrollView, "scrollY", positionToScroll).setDuration(600L).start();
    }

    private fun setTransaparentStatusbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rootConstraintLayout?.systemUiVisibility =
                SYSTEM_UI_FLAG_LAYOUT_STABLE or SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            ViewCompat.setOnApplyWindowInsetsListener(rootConstraintLayout) { view, insets ->
                setStatusbarColor(color = R.color.transparent)
                statusBarHeight = insets.systemWindowInsetTop
                topgap?.setSizeExt(height = statusBarHeight)
                insets.consumeSystemWindowInsets()
            }
        }
    }

    //--------get camera permission

    @WithPermissions(
        permissions = [Manifest.permission.CAMERA]
    )
    private fun getCameraPermission() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePhotoIntent ->
            takePhotoIntent.resolveActivity(packageManager)
        }
    }
}
