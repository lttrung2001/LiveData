package com.ltbth.livedata

import androidx.lifecycle.*
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class UserViewModel : ViewModel() {

//    val usersMediatorLiveData: MediatorLiveData<List<User>> by lazy {
//        MediatorLiveData<List<User>>()
//    }
    private val users: List<User> = arrayListOf(User(R.drawable.me, "Thành Trung", "Bla bla bla"))
    val mutableListLiveData: MutableLiveData<List<User>> by lazy {
        MutableLiveData()
    }

    init {
        mutableListLiveData.value = users
//        usersMediatorLiveData.addSource(mutableListLiveData) {
//            usersMediatorLiveData.value = it
//        }
    }

    fun descending() {
        mutableListLiveData.value?.let {
            Collections.sort(
                users
            ) { o1, o2 ->
                o2.name.compareTo(o1.name)
            }
            mutableListLiveData.value = users
//            usersMediatorLiveData.value = users
        }
    }

    fun ascending() {
        mutableListLiveData.value?.let {
            Collections.sort(
                users
            ) { o1, o2 ->
                o1.name.compareTo(o2.name)
            }
            mutableListLiveData.value = users
//            usersMediatorLiveData.value = users
        }
    }

    fun addUser(user: User) {
        (users as ArrayList<User>).add(user)
        mutableListLiveData.value = users
    }
}