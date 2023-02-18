package ble.ble.littlelemoncompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ble.ble.littlelemoncompose.ui.theme.LittleLemoncolor.charcoal
import ble.ble.littlelemoncompose.ui.theme.LittleLemoncolor.green

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = charcoal
    ),
    h2 = TextStyle(
        color = charcoal,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    body1 = TextStyle(
        color = green
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Bold,
        color = green
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */


)