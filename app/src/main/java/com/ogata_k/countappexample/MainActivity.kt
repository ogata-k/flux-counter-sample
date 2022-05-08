package com.ogata_k.countappexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ogata_k.countappexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class MainActivity : AppCompatActivity() , CoroutineScope by MainScope(){
    private lateinit var dispatcher: Dispatcher

    // cf. https://developer.android.com/topic/libraries/view-binding?hl=ja
    // 初期化方法がFragmentとActivityでは微妙に違うので注意
    private lateinit var binding: ActivityMainBinding
    private lateinit var store: CountupStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dispatcher = Dispatcher()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        store = ViewModelProvider(this, CountupStoreFactory(dispatcher))
            .get(CountupStore::class.java)

        store.count.observe(this, Observer {
            binding.CounterText.text = it.toString()
        })
        binding.CountupButton.setOnClickListener {
            CountupActionCreator(dispatcher).countup()
        }
    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }
}