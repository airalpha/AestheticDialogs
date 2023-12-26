package com.airalpha.aestheticdialogs

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class AestheticDialogs(
    val dialogStyle: DialogStyle,
    val dialogType: DialogType
) {
    var title = "Title"
    var message = "Message"


    /**
     * Set dialog title text
     *
     * @param title
     * @return this, for chaining.
     */
    fun setTitle(title: String): AestheticDialogs {
        this.title = title
        return this
    }

    /**
     * Set dialog message text
     *
     * @param message
     * @return this, for chaining.
     */
    fun setMessage(message: String): AestheticDialogs {
        this.message = message
        return this
    }

    fun show() {
        AestheticDialogManager.showDialog(this)
    }
}

@Composable
fun AestheticDialogsComponent() {
    val scope = rememberCoroutineScope()
    var visible by remember { mutableStateOf(true) }

    AestheticDialogManager.dialogs.forEach {
        when (it.dialogStyle) {
            DialogStyle.RAINBOW -> {
                RainBowDialog(it, onDismissRequest = {
                    AestheticDialogManager.dialogs.remove(it)
                })
            }

            else -> {

            }
        }

    }
}

@Composable
fun RainBowDialog(dialog: AestheticDialogs, onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = {
            onDismissRequest()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnClickOutside = true
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        color = when (dialog.dialogType) {
                            DialogType.SUCCESS -> colorResource(id = R.color.dialog_success)
                            DialogType.ERROR -> colorResource(id = R.color.dialog_error)
                            DialogType.WARNING -> colorResource(id = R.color.dialog_warning)
                            DialogType.INFO -> colorResource(id = R.color.dialog_info)
                        }
                    )
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.weight(.3f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check_circle_green_24dp),
                        contentDescription = "Success",
                        modifier = Modifier.size(30.dp),
                        tint = colorResource(id = R.color.md_white_1000)
                    )
                    Column {
                        Text(
                            text = dialog.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.md_white_1000)
                        )
                        Text(
                            text = dialog.message,
                            fontSize = 14.sp,
                            maxLines = 2,
                            lineHeight = 18.sp,
                            color = colorResource(id = R.color.md_white_1000)
                        )
                    }
                }
                IconButton(onClick = { onDismissRequest() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close_gray_24dp),
                        contentDescription = "Close",
                        modifier = Modifier.size(30.dp),
                        tint = colorResource(id = R.color.md_white_1000)
                    )
                }
            }
        }
    }
}