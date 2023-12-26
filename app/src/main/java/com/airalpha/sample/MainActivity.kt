package com.airalpha.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airalpha.aestheticdialogs.AestheticDialogManager
import com.airalpha.aestheticdialogs.AestheticDialogs
import com.airalpha.aestheticdialogs.AestheticDialogsComponent
import com.airalpha.aestheticdialogs.DialogStyle
import com.airalpha.aestheticdialogs.DialogType
import com.airalpha.sample.ui.theme.AestheticDialogsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AestheticDialogsTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Button(onClick = {
                        AestheticDialogs(DialogStyle.RAINBOW, DialogType.SUCCESS)
                            .setTitle("Rainbow")
                            .setMessage("This is a rainbow dialog !")
                            .show()
                    }) {
                        Text(text = "Success")
                    }
                    Button(onClick = {
                        AestheticDialogs(DialogStyle.RAINBOW, DialogType.ERROR)
                            .setTitle("Rainbow")
                            .setMessage("This is a rainbow dialog !")
                            .show()
                    }) {
                        Text(text = "Error")
                    }
                    Button(onClick = {
                        AestheticDialogs(DialogStyle.RAINBOW, DialogType.WARNING)
                            .setTitle("Rainbow")
                            .setMessage("This is a rainbow dialog !")
                            .show()
                    }) {
                        Text(text = "Warning")
                    }
                    Button(onClick = {
                        AestheticDialogs(DialogStyle.RAINBOW, DialogType.INFO)
                            .setTitle("Rainbow")
                            .setMessage("This is a rainbow dialog !")
                            .show()
                    }) {
                        Text(text = "Info")
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