package com.jafar.workshops

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.jafar.workshops.Fragments.StudentsDashboard
import com.jafar.workshops.Fragments.WorkshopScreen
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private var sectionsPagerAdapter: SectionPageAdapter? = null
    private val workshopScreen=WorkshopScreen()
    private val uid=FirebaseAuth.getInstance().uid
    private val studentsDashboard =StudentsDashboard()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        sectionsPagerAdapter = SectionPageAdapter(supportFragmentManager)

        container.adapter = sectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
        tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tab?.position)
                {

                    1->
                    {
                        if (uid==null)
                        {

                            startActivity(MainActivity.newIntent(this@SecondActivity))
                            Toast.makeText(this@SecondActivity,"Please Login",Toast.LENGTH_LONG).show()
                        }
                        else{
                            studentsDashboard
                        }


                    }
                }

            }
        })


    }

    companion object{

        fun newIntent(context: Context)= Intent(context, SecondActivity::class.java)
    }

    inner class SectionPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 ->workshopScreen
                else -> studentsDashboard
            }
        }

        override fun getCount() = 2

    }
}
