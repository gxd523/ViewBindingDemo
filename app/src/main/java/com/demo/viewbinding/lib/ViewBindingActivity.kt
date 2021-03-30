package com.demo.viewbinding.lib

import android.app.Activity
import android.os.Bundle
import androidx.viewbinding.ViewBinding

abstract class ViewBindingActivity<T : ViewBinding> : Activity() {
    private var _binding: T? = null
    val binding: T by lazy {
        val viewBindingClass = ViewBindingUtil.getViewBindingClass<T>(this@ViewBindingActivity)
        _binding = viewBindingClass?.callInflate(layoutInflater)

        if (_binding == null) {
            throw RuntimeException("Something wrong with ViewBinding init!")
        }
        _binding!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}