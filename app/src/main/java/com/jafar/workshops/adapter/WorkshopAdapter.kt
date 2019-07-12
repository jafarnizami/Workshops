package com.jafar.workshops.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jafar.workshops.R
import com.jafar.workshops.util.DATA
import com.jafar.workshops.util.ListItemClickListener
import java.net.BindException

class WorkshopAdapter(val work:ArrayList<DATA>):RecyclerView.Adapter<WorkshopAdapter.WorkshopViewHolder>()
{
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= WorkshopViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_workshop,parent,false)
    )

    override fun getItemCount()=work.size

    override fun onBindViewHolder(holder: WorkshopViewHolder, position: Int) {
        holder.Bind(work[position])
    }

    class WorkshopViewHolder(v:View):RecyclerView.ViewHolder(v)
    {




        private val heading = v.findViewById<TextView>(R.id.workshopheading)
        private val text =v.findViewById<TextView>(R.id.worshoptext)
        private val datee =v.findViewById<TextView>(R.id.workshopDate)
        private val button =v.findViewById<Button>(R.id.mybutton)

        fun Bind(data: DATA)
        {
            heading.text=data.heading
            text.text=data.text
            datee.text=data.date



        }

    }
}