package com.jafar.workshops.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jafar.workshops.R
import com.jafar.workshops.util.DATA

class StudentAdapter (val work:ArrayList<DATA>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= StudentViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_student,parent,false)
    )

    override fun getItemCount()=work.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.Bind(work[position])
    }

    class StudentViewHolder(v:View):RecyclerView.ViewHolder(v)
    {
        private val heading = v.findViewById<TextView>(R.id.workshopheading1)
        private val text =v.findViewById<TextView>(R.id.worshoptext1)
        private val datee =v.findViewById<TextView>(R.id.workshopDate1)

        fun Bind(data: DATA)
        {
            heading.text=data.heading
            text.text=data.text
            datee.text=data.date



        }

    }
}