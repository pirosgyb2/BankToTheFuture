package com.bme.aut.banktothefuture.Login

import android.app.ProgressDialog
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

abstract class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    private val firebaseUser: FirebaseUser?
        get() = FirebaseAuth.getInstance().currentUser

    protected val uid: String?
        get() = firebaseUser?.uid

    protected val userName: String?
        get() = firebaseUser?.displayName

    protected val userEmail: String?
        get() = firebaseUser?.email

    fun showProgressDialog() {
        if (progressDialog != null) {
            return
        }

        progressDialog = ProgressDialog(this).apply {
            setCancelable(false)
            setMessage("Töltés...")
            show()
        }
    }

    protected fun hideProgressDialog() {
        progressDialog?.let { dialog ->
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
        progressDialog = null
    }

    protected fun toast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun EditText.validateNonEmpty(): Boolean {
        if (text.isEmpty()) {
            error = "Szükséges"
            return false
        }
        return true
    }

}