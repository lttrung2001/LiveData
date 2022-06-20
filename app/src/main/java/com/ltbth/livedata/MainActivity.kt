package com.ltbth.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcvUser: RecyclerView
    private lateinit var btnAdd: Button
    private lateinit var btnSort: Button
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private var ascending = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcvUser = findViewById(R.id.rcv_user)
        btnAdd = findViewById(R.id.btn_add)
        btnSort = findViewById(R.id.btn_sort)

        rcvUser.layoutManager = LinearLayoutManager(this)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        // Quan sat du lieu thay doi
        val userObserver =
            Observer<List<User>> { t ->
                userAdapter = UserAdapter(t?: arrayListOf())
                rcvUser.adapter = userAdapter
            }

        userViewModel.mutableListLiveData.observe(this,userObserver)
        // Remove lang nghe su thay doi
//        userViewModel.mutableListLiveData.removeObserver(observer)

        btnAdd.setOnClickListener {
            val user = User(R.drawable.me,"Username ${userAdapter.itemCount}","Bla bla bla")
            userViewModel.addUser(user)
        }

        btnSort.setOnClickListener {
            if (ascending) {
                Toast.makeText(this@MainActivity,"ASCENDING",Toast.LENGTH_SHORT).show()
                userViewModel.descending()
                ascending = false
            } else {
                Toast.makeText(this@MainActivity,"DESCENDING",Toast.LENGTH_SHORT).show()
                userViewModel.ascending()
                ascending = true
            }
        }
    }
}