package com.ltbth.livedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.user_img)
        val name: TextView = itemView.findViewById(R.id.user_name)
        val desc: TextView = itemView.findViewById(R.id.user_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.let {
            val user = users[position]
            it.avatar.setImageResource(user.img)
            it.name.text = user.name
            it.desc.text = user.desc
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}