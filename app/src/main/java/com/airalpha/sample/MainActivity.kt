package com.airalpha.sample

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airalpha.aestheticdialogs.AestheticDialogs
import com.airalpha.aestheticdialogs.AestheticDialogsComponent
import com.airalpha.aestheticdialogs.DialogAnimation
import com.airalpha.aestheticdialogs.DialogStyle
import com.airalpha.aestheticdialogs.DialogType
import com.airalpha.sample.ui.theme.AestheticDialogsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val errorMessage = "A failure occurred during registration"
            val successMessage = "The message was sent successfully !"
            val warningMessage = "Please verify that you have completed all fields"
            val infoMessage = "Your request has been updated"
            val infoTitle = "Info"
            val successTitle = "Success"
            val errorTitle = "Error"
            val warningTitle = "Warning"

            AestheticDialogsTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Button(onClick = {
                        AestheticDialogs.Builder(DialogStyle.TOASTER, DialogType.SUCCESS)
                            .setTitle(successTitle)
                            .setMessage(successMessage)
                            .setAnimation(DialogAnimation.SLIDE)
                            .setGravity(Gravity.TOP)
                            .show()
                    }) {
                        Text(text = "Success")
                    }
                    Button(onClick = {
                        AestheticDialogs.Builder(DialogStyle.TOASTER, DialogType.ERROR)
                            .setTitle(errorTitle)
                            .setMessage(errorMessage)
                            .setAnimation(DialogAnimation.EXPAND_UP)
                            .show()
                    }) {
                        Text(text = "Error")
                    }
                    Button(onClick = {
                        AestheticDialogs.Builder(DialogStyle.RAINBOW, DialogType.WARNING)
                            .setTitle(warningTitle)
                            .setMessage(warningMessage)
                                .setAnimation(DialogAnimation.EXPAND_LEFT)
                            .show()
                    }) {
                        Text(text = "Warning")
                    }
                    Button(onClick = {
                        AestheticDialogs.Builder(DialogStyle.RAINBOW, DialogType.INFO)
                            .setTitle(infoTitle)
                            .setMessage(infoMessage)
                            .setDuration(3000)
                            .setAnimation(DialogAnimation.SLIDE_RIGHT)
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