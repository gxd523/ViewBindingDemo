package com.demo.viewbinding

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Created by guoxiaodong on 3/29/21 17:46
 */
class ListActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ListFragment())
            .commitNow()
    }
}