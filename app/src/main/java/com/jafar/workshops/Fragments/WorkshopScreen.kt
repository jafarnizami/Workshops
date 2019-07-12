package com.jafar.workshops.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

import com.jafar.workshops.R
import com.jafar.workshops.adapter.WorkshopAdapter
import com.jafar.workshops.util.DATA
import kotlinx.android.synthetic.main.fragment_workshop_screen.*
import kotlinx.android.synthetic.main.fragment_workshop_screen.view.*
import java.util.*
import kotlin.collections.ArrayList

class WorkshopScreen : Fragment() {
    private val firebaseDB=FirebaseFirestore.getInstance()
    private val x =ArrayList<DATA>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_workshop_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       val ref = firebaseDB.collection("WORKSHOPS").get()
            .addOnSuccessListener {

         it.forEach {
             Log.d("pui","DATA SNAPSHOTS:${it.data}")
             val data =it.toObject(DATA::class.java)
             data?.let {
                 x.add(data)
             }
         }
                rv.layoutManager=LinearLayoutManager(requireContext())
                rv.adapter=WorkshopAdapter(x)




            }





        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing=false
        }

    }


}
