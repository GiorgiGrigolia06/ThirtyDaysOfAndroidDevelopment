package com.example.thirtydaysofandroiddevelopment.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydaysofandroiddevelopment.R

val DM_Sans = FontFamily(
    Font(R.font.dm_sans_regular, FontWeight.Normal),
    Font(R.font.dm_sans_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = DM_Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    displayLarge = TextStyle(
        fontFamily = DM_Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),

    displayMedium = TextStyle(
        fontFamily = DM_Sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),

    displaySmall = TextStyle(
        fontFamily = DM_Sans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )
)