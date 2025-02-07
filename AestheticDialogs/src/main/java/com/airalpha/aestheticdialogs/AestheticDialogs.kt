package com.airalpha.aestheticdialogs

import android.os.Handler
import android.os.Looper
import android.view.Gravity
import androidx.annotation.GravityInt
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.airalpha.aestheticdialogs.dialogs.FlashDialog
import com.airalpha.aestheticdialogs.dialogs.RainBowDialog
import com.airalpha.aestheticdialogs.dialogs.ToasterDialog
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AestheticDialogs {
    class Builder(
        //Necessary parameters
        val dialogStyle: DialogStyle,
        val dialogType: DialogType
    ) {
        var title = "Title"
        var message = "Message"

        // Optional parameters
        var duration: Long? = null

        @GravityInt
        var gravity: Int = Gravity.NO_GRAVITY
        var animation: DialogAnimation = DialogAnimation.DEFAULT
        var darkMode: Boolean = false


        /**
         * Set dialog title text
         *
         * @param title
         * @return this, for chaining.
         */
        fun setTitle(title: String) = apply {
            this.title = title
        }

        /**
         * Set dialog message text
         *
         * @param message
         * @return this, for chaining.
         */
        fun setMessage(message: String) = apply {
            this.message = message
        }

        /**
         * Set dialog duration
         *
         * @param duration
         * @return this, for chaining.
         */
        fun setDuration(duration: Long) = apply {
            this.duration = duration
        }

        /**
         * Set dialog gravity
         *
         * @param gravity
         * @return this, for chaining.
         */
        fun setGravity(@GravityInt gravity: Int) = apply {
            this.gravity = gravity
        }

        /**
         * Set dialog animation
         *
         * @param animation
         * @return this, for chaining.
         */
        fun setAnimation(animation: DialogAnimation) = apply {
            this.animation = animation
        }

        /**
         * Set dialog darkmode
         *
         * @param darkmode
         * @return this, for chaining.
         */
        fun setDarkMode(darkMode: Boolean) = apply {
            this.darkMode = darkMode
        }

        fun show() {
            AestheticDialogsManager.showDialog(this)
        }

        fun close() {
            AestheticDialogsManager.closeDialog(this)
        }
    }
}

@Composable
fun AestheticDialogsComponent() {
    AestheticDialogsManager.dialogs.forEach {
        DialogWrapper(dialog = it, onDismissRequest = { it.close() }) { close ->
            when (it.dialogStyle) {
                DialogStyle.RAINBOW -> {
                    RainBowDialog(it) {
                        close()
                    }
                }

                DialogStyle.TOASTER -> {
                    ToasterDialog(it) {
                        close()
                    }
                }

                DialogStyle.FLASH -> {
                    FlashDialog(it) {
                        close()
                    }
                }

                else -> {

                }
            }
        }

    }
}

@Composable
fun DialogWrapper(
    dialog: AestheticDialogs.Builder,
    onDismissRequest: () -> Unit,
    content: @Composable (() -> Unit) -> Unit
) {
    val scope = rememberCoroutineScope()
    val isVisible = remember { mutableStateOf(false) }

    fun closeDialog() {
        scope.launch {
            isVisible.value = false
            delay(300)
            onDismissRequest()
        }
    }

    LaunchedEffect(key1 = true) {
        isVisible.value = true
        dialog.duration?.let {
            Handler(Looper.getMainLooper()).postDelayed({
                closeDialog()
            }, it)
        }
    }

    Dialog(
        onDismissRequest = {
            closeDialog()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnClickOutside = true
        )
    ) {
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        dialogWindowProvider.window.setGravity(dialog.gravity)

        AnimatedVisibility(
            visible = isVisible.value,
            enter = dialog.animation.enterAnim(),
            exit = dialog.animation.exitAnim()
        ) {
            content {
                closeDialog()
            }
        }
    }
}