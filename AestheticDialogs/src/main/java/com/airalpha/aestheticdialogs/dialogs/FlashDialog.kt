package com.airalpha.aestheticdialogs.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airalpha.aestheticdialogs.AestheticDialogs
import com.airalpha.aestheticdialogs.DialogType
import com.airalpha.aestheticdialogs.R

@Composable
fun FlashDialog(dialog: AestheticDialogs.Builder, onClose: () -> Unit) {
    val brush = when (dialog.dialogType) {
        DialogType.SUCCESS -> Brush.verticalGradient(
            colors = listOf(
                Color(0xFF54DBE4),
                Color(0xFF33D6C1),
                Color(0xFF16E5AB)
            )
        )
        DialogType.ERROR -> Brush.verticalGradient(
            colors = listOf(
                Color(0xFFFF5FBA),
                Color(0xFFFF3159),
                Color(0xFFFF4889)
            )
        )
        else -> Brush.verticalGradient(
            colors = listOf(
                Color(0xFF54DBE4),
                Color(0xFF33D6C1),
                Color(0xFF16E5AB)
            )
        )
    }
    Card(
        modifier = Modifier
            .height(310.dp)
            .width(300.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(30.dp),
    ) {
        Column(
            modifier = Modifier
                .background(brush)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = when(dialog.dialogType) {
                    DialogType.SUCCESS -> R.drawable.circle_validation_success
                    DialogType.ERROR -> R.drawable.circle_validation_error
                    else -> R.drawable.circle_validation_success
                }),
                contentDescription = "image",
                modifier = Modifier
                    .size(120.dp)
                    .padding(vertical = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = dialog.title,
                modifier = Modifier
                    .wrapContentSize(Alignment.Center).padding(horizontal = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = colorResource(id = R.color.md_white_1000)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center).padding(horizontal = 10.dp),
                textAlign = TextAlign.Center,
                text = dialog.message,
                fontSize = 16.sp,
                maxLines = 3,
                lineHeight = 18.sp,
                color = colorResource(id = R.color.md_white_1000)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedButton(
                onClick = { onClose() },
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = colorResource(id = R.color.md_white_1000),
                ),
                border = BorderStroke(
                    1.dp,
                    color = colorResource(id = R.color.md_white_1000)
                )
            ) {
                Text(text = "OK")
            }
        }
    }
}