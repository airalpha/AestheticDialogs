package com.airalpha.aestheticdialogs.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airalpha.aestheticdialogs.AestheticDialogs
import com.airalpha.aestheticdialogs.DialogType
import com.airalpha.aestheticdialogs.R

@Composable
fun RainBowDialog(dialog: AestheticDialogs.Builder, onClose: () -> Unit) {
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
                painter = painterResource(
                    id = when (dialog.dialogType) {
                        DialogType.SUCCESS -> R.drawable.ic_check_circle_green_24dp
                        DialogType.ERROR -> R.drawable.ic_error_red_24dp
                        DialogType.WARNING -> R.drawable.ic_warning_orange_24dp
                        DialogType.INFO -> R.drawable.ic_info_blue_24dp
                    }
                ),
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
        IconButton(onClick = {
            onClose()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close_gray_24dp),
                contentDescription = "Close",
                modifier = Modifier.size(30.dp),
                tint = colorResource(id = R.color.md_white_1000)
            )
        }
    }

}