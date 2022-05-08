package com.ogata_k.countappexample

sealed class CountupActionEvent {
    // システムの要求結果をEventとして流す
    // アクションのEvent名は内容を見なくても、アプリケーションで何が起こったのかを十分に理解できるようにする
    // システムの要求結果なのでEvent名は過去形にする。
    object CountupRequest : CountupActionEvent()
    data class UpdateCountupValue(val value: Int) : CountupActionEvent()
}
