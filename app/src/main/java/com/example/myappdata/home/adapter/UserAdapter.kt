package com.example.firebasemvp.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasemvp.home.UserCallback
import com.example.firebasemvp.home.model.UserListModel
import com.example.myappdata.R
import com.example.retrofitfirebasemvp.home.adapter.UserHolder

class UserAdapter(var userModel: List<UserListModel>, var callback: UserCallback?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolderContext: Context = parent.context
        return UserHolder(
            LayoutInflater.from(viewHolderContext).inflate(
                R.layout.item_member_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = userModel.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserHolder).bindData(
            userListModel = userModel[position],
            callback = callback
        )
    }

    fun updateDataUserList(userModel: List<UserListModel>) {
        this.userModel = userModel
        notifyDataSetChanged()
    }

}