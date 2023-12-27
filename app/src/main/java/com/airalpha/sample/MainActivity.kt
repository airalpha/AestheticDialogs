package com.airalpha.sample

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.airalpha.aestheticdialogs.AestheticDialogs
import com.airalpha.aestheticdialogs.AestheticDialogsComponent
import com.airalpha.aestheticdialogs.DialogAnimation
import com.airalpha.aestheticdialogs.DialogStyle
import com.airalpha.aestheticdialogs.DialogType
import com.airalpha.sample.Constants.errorMessage
import com.airalpha.sample.Constants.errorTitle
import com.airalpha.sample.Constants.infoMessage
import com.airalpha.sample.Constants.infoTitle
import com.airalpha.sample.Constants.successMessage
import com.airalpha.sample.Constants.successTitle
import com.airalpha.sample.Constants.warningMessage
import com.airalpha.sample.Constants.warningTitle
import com.airalpha.sample.components.CustomButton
import com.airalpha.sample.components.RainbowDemo
import com.airalpha.sample.components.ToasterDemo
import com.airalpha.sample.ui.theme.AestheticDialogsTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AestheticDialogsTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Aesthetic Dialogs !") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = it.calculateTopPadding() + 16.dp,
                                bottom = it.calculateBottomPadding(),
                                start = it.calculateStartPadding(LayoutDirection.Ltr) + 16.dp,
                                end = it.calculateEndPadding(LayoutDirection.Ltr) + 16.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ToasterDemo()
                        RainbowDemo()
                    }
                }

                AestheticDialogsComponent()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AestheticDialogsTheme {
        Greeting("Android")
    }
}