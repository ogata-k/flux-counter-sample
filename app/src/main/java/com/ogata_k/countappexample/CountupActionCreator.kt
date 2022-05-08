package com.ogata_k.countappexample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CountupActionCreator (private val dispatcher: Dispatcher): CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO + Job()

    fun countup() {
        launch {
            dispatcher.dispatch(CountupActionEvent.CountupRequest)
        }
    }
}