package com.airalpha.aestheticdialogs

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

object AestheticDialogManager {
    val dialogs = mutableStateListOf<AestheticDialogs>()

    fun showDialog(dialog: AestheticDialogs) {
        dialogs.add(dialog)
    }
}