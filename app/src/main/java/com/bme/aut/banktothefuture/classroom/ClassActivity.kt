package com.bme.aut.banktothefuture.classroom

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bme.aut.banktothefuture.R

import kotlinx.android.synthetic.main.activity_class.*

class ClassActivity : AppCompatActivity() {

    private val data = MockDB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)
        setSupportActionBar(toolbar)

        setUpRecyclerView()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setUpRecyclerView(){
        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = CustomAdapter(data.getStudentList())
        recyclerView1.adapter = adapter
    }

}
