package com.example.composethemes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composethemes.ui.theme.ComposeThemesTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           myApp()
        }
    }
}

@Composable
fun myApp() {
    val isDarkTheme = isSystemInDarkTheme()

    MaterialTheme(
        colors = if (isDarkTheme) DarkThemeColors else LightThemeColors
    ) {
        Surface(color = MaterialTheme.colors.background) {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    Text(
        text = "Jetpack Compose Material Theme Örneği",
        style = MaterialTheme.typography.h4,
        color = MaterialTheme.colors.primary
    )
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    MaterialTheme(colors = LightThemeColors) {
        AppContent()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    MaterialTheme(colors = DarkThemeColors) {
        AppContent()
    }
}

private val LightThemeColors = lightColors(
    primary = Color.Blue,
    secondary = Color.Red
)

private val DarkThemeColors = darkColors(
    primary = Color.Cyan,
    secondary = Color.Yellow
)
