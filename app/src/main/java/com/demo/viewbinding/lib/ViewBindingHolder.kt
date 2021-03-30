package com.demo.viewbinding.lib

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ViewBindingHolder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)