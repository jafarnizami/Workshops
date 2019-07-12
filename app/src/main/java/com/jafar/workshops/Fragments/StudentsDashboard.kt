package com.jafar.workshops.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.jafar.workshops.R
import com.jafar.workshops.adapter.StudentAdapter
import com.jafar.workshops.adapter.WorkshopAdapter
import com.jafar.workshops.util.DATA
import kotlinx.android.synthetic.main.fragment_students_dashboard.*
import kotlinx.android.synthetic.main.fragment_workshop_screen.*


class StudentsDashboard : Fragment() {
    private val x =ArrayList<DATA>()
    private val firebaseDB= FirebaseFirestore.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_students_dashboard, container, false)
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
                rv2.layoutManager= LinearLayoutManager(requireContext())
                rv2.adapter= StudentAdapter(x)




            }


    }


}




