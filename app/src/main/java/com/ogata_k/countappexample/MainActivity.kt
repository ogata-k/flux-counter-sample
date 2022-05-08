package com.ogata_k.countappexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ogata_k.countappexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // cf. https://developer.android.com/topic/libraries/view-binding?hl=ja
    // 初期化方法がFragmentとActivityでは微妙に違うので注意
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // @todo set binding value e.g. binding.initialText = <livedata>
    }
}