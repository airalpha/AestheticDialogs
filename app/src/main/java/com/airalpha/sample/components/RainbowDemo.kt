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
fun RainbowDemo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "RAINBOW DIALOG",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        CustomButton(title = "SUCCESS") {
            AestheticDialogs.Builder(DialogStyle.RAINBOW, DialogType.SUCCESS)
                .setTitle(Constants.successTitle)
                .setMessage(Constants.successMessage)
                .show()
        }
        CustomButton(title = "ERROR") {
            AestheticDialogs.Builder(DialogStyle.RAINBOW, DialogType.ERROR)
                .setTitle(Constants.errorTitle)
                .setMessage(Constants.errorMessage)
                .show()
        }
        CustomButton(title = "INFO") {
            AestheticDialogs.Builder(DialogStyle.RAINBOW, DialogType.INFO)
                .setTitle(Constants.infoTitle)
                .setMessage(Constants.infoMessage)
                .show()
        }
        CustomButton(title = "WARNING") {
            AestheticDialogs.Builder(DialogStyle.RAINBOW, DialogType.WARNING)
                .setTitle(Constants.warningTitle)
                .setMessage(Constants.warningMessage)
                .show()
        }
    }
}