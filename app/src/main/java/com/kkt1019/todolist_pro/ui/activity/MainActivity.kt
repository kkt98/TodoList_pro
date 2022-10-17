package com.kkt1019.todolist_project.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.kkt1019.todolist_pro.R
import com.kkt1019.todolist_pro.databinding.ActivityMainBinding
import com.kkt1019.todolist_pro.ui.fragment.CalenderFragment
import com.kkt1019.todolist_pro.ui.fragment.FinishFragment
import com.kkt1019.todolist_pro.ui.fragment.TodoListFragment

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.container_fragment, TodoListFragment()).commit()

        binding.layotTab.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    "리스트" -> {
                        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, TodoListFragment()).commit()
                    }
                    "달력" -> {
                        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, CalenderFragment()).commit()
                    }
                    "완료" -> {
                        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, FinishFragment()).commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }


        })
    }
}