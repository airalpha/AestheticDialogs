package com.airalpha.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.airalpha.aestheticdialogs.AestheticDialogs
import com.airalpha.aestheticdialogs.DialogStyle
import com.airalpha.aestheticdialogs.DialogType
import com.airalpha.sample.Constants

@Composable
fun FlashDemo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "FLASH DIALOG",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        CustomButton(title = "SUCCESS") {
            AestheticDialogs.Builder(DialogStyle.FLASH, DialogType.SUCCESS)
                .setTitle(Constants.successTitle)
                .setMessage(Constants.successMessage)
                .show()
        }
        CustomButton(title = "ERROR") {
            AestheticDialogs.Builder(DialogStyle.FLASH, DialogType.ERROR)
                .setTitle(Constants.errorTitle)
                .setMessage(Constants.errorMessage)
                .show()
        }
    }
}