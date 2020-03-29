package com.bme.aut.banktothefuture.Login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import com.bme.aut.banktothefuture.MainActivity
import com.bme.aut.banktothefuture.R
import com.bme.aut.banktothefuture.setSizeExt
import com.bme.aut.banktothefuture.setStatusbarColor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    private var statusBarHeight = 0

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener { registerClick() }
        btnLogin.setOnClickListener { loginClick() }

    }

    override fun onResume() {
        super.onResume()
        setTransaparentStatusbar()
    }


    private fun validateForm() = etEmail.validateNonEmpty() && etPassword.validateNonEmpty()

    private fun registerClick() {
        if (!validateForm()) {
            return
        }

        showProgressDialog()

        firebaseAuth
            .createUserWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
            .addOnSuccessListener { result ->
                hideProgressDialog()

                val firebaseUser = result.user
                val profileChangeRequest = UserProfileChangeRequest.Builder()
                    .setDisplayName(firebaseUser?.email?.substringBefore('@'))
                    .build()
                firebaseUser?.updateProfile(profileChangeRequest)

                toast("Sikeres regisztráció")
            }
            .addOnFailureListener { exception ->
                hideProgressDialog()

                toast(exception.message)
            }
    }

    private fun loginClick() {
        if (!validateForm()) {
            return
        }

        showProgressDialog()

        firebaseAuth
            .signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
            .addOnSuccessListener {
                hideProgressDialog()

                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { exception ->
                hideProgressDialog()

                toast(exception.localizedMessage)
            }
    }


    private fun setTransaparentStatusbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            loginTopView?.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            ViewCompat.setOnApplyWindowInsetsListener(loginTopView) { view, insets ->
                setStatusbarColor(color = R.color.transparent)
                statusBarHeight = insets.systemWindowInsetTop
                loginTopView?.setSizeExt(height = statusBarHeight)
                insets.consumeSystemWindowInsets()
            }
        }
    }
}
