package com.bme.aut.banktothefuture

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_qr.*

class QrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            takePhoto()
        }
    }

    private fun takePhoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                takePhotoIntent ->
            takePhotoIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePhotoIntent, 1001)
            }
        }
    }

}
