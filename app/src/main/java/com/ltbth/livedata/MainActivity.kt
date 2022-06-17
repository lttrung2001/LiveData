package com.ltbth.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcvUser: RecyclerView
    private lateinit var btnAdd: Button
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcvUser = findViewById(R.id.rcv_user)
        btnAdd = findViewById(R.id.btn_add)

        rcvUser.layoutManager = LinearLayoutManager(this)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        // Quan sat du lieu thay doi
        val observer = object: Observer<List<User>> {
            override fun onChanged(t: List<User>?) {
                userAdapter = UserAdapter(t?: arrayListOf())
                rcvUser.adapter = userAdapter
            }
        }

        userViewModel.mutableListLiveData.observe(this,observer)
        // Remove lang nghe su thay doi
//        userViewModel.mutableListLiveData.removeObserver(observer)

        btnAdd.setOnClickListener {
            val user = User(R.drawable.me,"Username ${userAdapter.itemCount}","Bla bla bla")
            userViewModel.addUser(user)
        }
    }
}