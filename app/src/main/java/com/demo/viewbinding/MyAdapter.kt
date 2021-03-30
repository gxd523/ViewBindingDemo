package com.demo.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.viewbinding.databinding.ItemListBinding
import com.demo.viewbinding.lib.ViewBindingHolder

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBindViewHolder(position)
    }

    override fun getItemCount(): Int = 20

    class MyViewHolder(parent: ViewGroup) : ViewBindingHolder<ItemListBinding>(
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) {
        fun onBindViewHolder(position: Int) {
            binding.itemIv.setImageResource(android.R.mipmap.sym_def_app_icon)
            binding.itemTv.text = "第${position}个Item"
            binding.root.setBackgroundColor(if (position % 2 == 0) 0x66FFFF00 else 0x6600FFFF)
        }
    }
}