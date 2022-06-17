package com.ltbth.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var mutableListLiveData: MutableLiveData<List<User>> = MutableLiveData()
    var users: List<User> = arrayListOf(User(R.drawable.me,"Thành Trung","Bla bla bla"))
    init {
        mutableListLiveData.value = users
    }

    fun addUser(user: User) {
        (users as ArrayList<User>).add(user)
        mutableListLiveData.value = users
    }
}