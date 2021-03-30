package com.demo.viewbinding

import android.content.Intent
import android.os.Bundle
import com.demo.viewbinding.databinding.ActivityMainBinding
import com.demo.viewbinding.databinding.LayoutMergeBinding
import com.gxd.viewbindingwrapper.ViewBindingActivity

class MainActivity : ViewBindingActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.titleTv.apply {
            text = "Hello World!"
            setOnClickListener {
                startActivity(Intent(this@MainActivity, ListActivity::class.java))
            }
        }
        binding.layoutInclude.includeTitleTv.text = "Test Include!"
        val mergeBinding = LayoutMergeBinding.bind(binding.root)
        mergeBinding.mergeTitleTv.text = "Test Merge!"


    }
}