package com.ogata_k.countappexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class CountupStoreFactory(private var dispatcher: Dispatcher) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountupStore(dispatcher) as T
    }
}