package com.demo.viewbinding

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.viewbinding.databinding.FragmentListBinding
import com.gxd.viewbindingwrapper.ViewBindingFragment

class ListFragment : ViewBindingFragment<FragmentListBinding>() {
    override fun FragmentListBinding.onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.listTitleTv.text = "这是一个标题"
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = MyAdapter()
        }
    }

}