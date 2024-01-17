package com.example.wsw.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

private val LightColors = lightColorScheme(
    primary = greenPrimary,
    secondary = greenSecondary,
    tertiary = greenBackground
)

val Colors = lightColors(
    surface = Color("#F1F2EC".toColorInt()),
    onSurface = Color("#D3C9AF".toColorInt()),
    primary = Color("#4D96C2".toColorInt()),
    onPrimary = Color("#9DBCDA".toColorInt()),
    secondary = Color("#253A51".toColorInt()))

@Composable
fun WSWTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = Colors, content = content)
}