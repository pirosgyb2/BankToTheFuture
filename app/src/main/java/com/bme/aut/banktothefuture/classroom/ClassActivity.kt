package com.bme.aut.banktothefuture.classroom

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bme.aut.banktothefuture.MainActivity
import com.bme.aut.banktothefuture.QrActivity
import com.bme.aut.banktothefuture.R

import kotlinx.android.synthetic.main.activity_class.*

class ClassActivity : AppCompatActivity() {

    private val data = MockDB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature( Window.FEATURE_NO_TITLE )

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN )

        setContentView(R.layout.activity_class)

        setUpRecyclerView()

        fab.setOnClickListener { view ->
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }


    }

    private fun setUpRecyclerView(){
        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = CustomAdapter(data.getStudentList())
        recyclerView1.adapter = adapter
    }

}
