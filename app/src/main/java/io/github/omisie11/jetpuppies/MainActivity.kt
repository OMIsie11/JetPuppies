package io.github.omisie11.jetpuppies

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import io.github.omisie11.jetpuppies.ui.JetPuppiesApp
import io.github.omisie11.jetpuppies.ui.screens.main.MainScreen
import io.github.omisie11.jetpuppies.ui.theme.JetPuppiesTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPuppiesApp()
        }
    }
}