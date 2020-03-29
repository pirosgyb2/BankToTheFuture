package com.bme.aut.banktothefuture.classroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.banktothefuture.R

class CustomAdapter(val studentList: ArrayList<Student>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvTitle?.text = studentList[position].nickName
        holder?.tvAmount?.text = studentList[position].money
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent?.context).inflate(R.layout.student_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvAmount = itemView.findViewById<TextView>(R.id.tvAmount)
    }

}