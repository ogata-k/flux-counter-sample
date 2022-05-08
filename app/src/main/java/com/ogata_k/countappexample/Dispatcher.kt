package com.ogata_k.countappexample

import android.util.Log
import org.greenrobot.eventbus.EventBus

class Dispatcher {
    companion object {
        const val TAG: String = "Dispatcher"
    }

    private val actionBus: EventBus = EventBus.getDefault()

    fun dispatch(event: Any) {
        actionBus.post(event)
    }

    fun register(observer: Any) {
        if (!actionBus.isRegistered(observer)) {
            actionBus.register(observer)
        } else {
            Log.e(TAG, "Subscriber $observer already registered to event ")
        }
    }

    fun unregister(observer: Any) {
        if (actionBus.isRegistered(observer)) {
            actionBus.unregister(observer)
        } else {
            Log.e(TAG, "Subscriber to unregister was not registered before: $observer")
        }
    }
}