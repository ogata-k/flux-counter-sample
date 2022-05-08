package com.ogata_k.countappexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CountupStore(private val dispatcher: Dispatcher)
    : ViewModel(), CoroutineScope by MainScope(){
    // 必要ならリポジトリの参照をここに渡す
    init {
        dispatcher.register(this)
    }

    override fun onCleared() {
        cancel()
        dispatcher.unregister(this)
        super.onCleared()
    }

    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

    @Subscribe(threadMode = ThreadMode.ASYNC)
    fun on(event: CountupActionEvent.CountupRequest) {
        val currentValue = _count.value
        if(currentValue == null){
            dispatcher.dispatch(CountupActionEvent.UpdateCountupValue(0))
        } else {
            dispatcher.dispatch(CountupActionEvent.UpdateCountupValue(currentValue + 1))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun on(event: CountupActionEvent.UpdateCountupValue) {
        _count.value = event.value
    }
}