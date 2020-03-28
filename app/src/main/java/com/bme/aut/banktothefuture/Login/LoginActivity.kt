package com.bme.aut.banktothefuture.Login

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bme.aut.banktothefuture.MainActivity
import com.bme.aut.banktothefuture.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener { registerClick() }
        btnLogin.setOnClickListener { loginClick() }

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

}
