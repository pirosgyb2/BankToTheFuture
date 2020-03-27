package com.bme.aut.banktothefuture

import android.Manifest
import android.content.Intent
import android.graphics.PointF
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dlazaro66.qrcodereaderview.QRCodeReaderView
import com.livinglifetechway.quickpermissions.annotations.WithPermissions

import kotlinx.android.synthetic.main.activity_qr.*

class QrActivity : AppCompatActivity(), QRCodeReaderView.OnQRCodeReadListener {
    private val resultTextView: TextView ?= null
    private val qrCodeReaderView:QRCodeReaderView ?= null

    override fun onQRCodeRead(text:String?, points: Array<out PointF>?) {
        resultTextView?.text = text
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }
    override fun onResume() {
        super.onResume()
        qrCodeReaderView?.startCamera()
    }
    override fun onPause() {
        super.onPause()
        qrCodeReaderView?.stopCamera()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)
        setSupportActionBar(toolbar)

        getCameraPermission()

        val qrCodeReaderView = findViewById<QRCodeReaderView>(R.id.qrdecoderview)
        qrCodeReaderView.setOnQRCodeReadListener(this)
        // Use this function to enable/disable decoding
        qrCodeReaderView.setQRDecodingEnabled(true)
        // Use this function to change the autofocus interval (default is 5 secs)
        qrCodeReaderView.setAutofocusInterval(2000L)
        // Use this function to enable/disable Torch
        qrCodeReaderView.setTorchEnabled(true)
        // Use this function to set front camera preview
        qrCodeReaderView.setFrontCamera()
        // Use this function to set back camera preview
        qrCodeReaderView.setBackCamera()
    }

    @WithPermissions(
        permissions = [Manifest.permission.CAMERA]
    )
    private fun getCameraPermission() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                takePhotoIntent ->
            takePhotoIntent.resolveActivity(packageManager)
        }
    }
}
