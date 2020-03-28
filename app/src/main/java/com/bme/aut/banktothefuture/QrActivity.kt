package com.bme.aut.banktothefuture

import android.content.Intent
import android.graphics.PointF
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.dlazaro66.qrcodereaderview.QRCodeReaderView
import kotlinx.android.synthetic.main.activity_qr.*

class QrActivity : AppCompatActivity(), QRCodeReaderView.OnQRCodeReadListener {
    private var statusBarHeight = 0

    private val resultTextView: TextView? = null
    private val qrCodeReaderView: QRCodeReaderView? = null

    override fun onQRCodeRead(text: String?, points: Array<out PointF>?) {
        resultTextView?.text = text
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }

    override fun onResume() {
        super.onResume()
        setTransaparentStatusbar()
        qrCodeReaderView?.startCamera()
    }

    override fun onPause() {
        super.onPause()
        qrCodeReaderView?.stopCamera()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

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

    private fun setTransaparentStatusbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rootCoordinatorLayout?.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            ViewCompat.setOnApplyWindowInsetsListener(rootCoordinatorLayout) { view, insets ->
                setStatusbarColor(color = R.color.transparent)
                statusBarHeight = insets.systemWindowInsetTop
                insets.consumeSystemWindowInsets()
            }
        }
    }
}
