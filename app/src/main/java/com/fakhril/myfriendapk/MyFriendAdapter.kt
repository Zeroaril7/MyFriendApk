package com.fakhril.myfriendapk

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fakhril.myfriendapk.databinding.MyFriendItemBinding

class MyFriendAdapter(private val context: Context, private val items: ArrayList<MyFriend>) :
    RecyclerView.Adapter<MyFriendAdapter.DataViewHolder>() {



    inner class DataViewHolder(val binding: MyFriendItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: MyFriend){
            binding.txtFriendName.text = item.nama
            binding.txtFriendEmail.text = item.email
            binding.txtFriendTelp.text = item.telp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = MyFriendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }


}