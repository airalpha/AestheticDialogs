package com.airalpha.aestheticdialogs

import androidx.compose.runtime.mutableStateListOf

object AestheticDialogsManager {
    val dialogs = mutableStateListOf<AestheticDialogs.Builder>()

    fun showDialog(dialog: AestheticDialogs.Builder) {
        dialogs.add(dialog)
    }

    fun closeDialog(dialog: AestheticDialogs.Builder) {
        dialogs.remove(dialog)
    }
}