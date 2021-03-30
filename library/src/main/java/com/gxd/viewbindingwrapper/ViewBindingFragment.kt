package com.gxd.viewbindingwrapper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    val binding: T by lazy {
        _binding!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        createViewBinding(inflater, container)
        return binding.root
    }

    private fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?) {
        val viewBindingClass = ViewBindingUtil.getViewBindingClass<T>(this@ViewBindingFragment)
        _binding = viewBindingClass?.callInflate(inflater, container, false)

        if (_binding == null) {
            throw RuntimeException("Something wrong with ViewBinding init!")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun T.onViewCreated(view: View, savedInstanceState: Bundle?)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.onViewCreated(view, savedInstanceState)
    }
}