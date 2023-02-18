package ble.ble.littlelemoncompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import ble.ble.littlelemoncompose.ui.theme.LittleLemoncolor.charcoal
import ble.ble.littlelemoncompose.ui.theme.LittleLemoncolor.cloud
import ble.ble.littlelemoncompose.ui.theme.LittleLemoncolor.pink
import ble.ble.littlelemoncompose.ui.theme.LittleLemoncolor.yellow

private val DarkColorPalette = darkColors(
    primary = pink,
    primaryVariant = charcoal,
    secondary = cloud
)

private val LightColorPalette = lightColors(
    primary = yellow,
    primaryVariant = charcoal,
    secondary = cloud

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun LittleLemonComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}