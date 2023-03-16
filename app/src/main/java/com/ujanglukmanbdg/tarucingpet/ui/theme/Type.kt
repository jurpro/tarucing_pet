package com.ujanglukmanbdg.tarucingpet.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ujanglukmanbdg.tarucingpet.R

val EncodeSans = FontFamily(
    Font(R.font.encode_sans_condensed_black, FontWeight.Black),
    Font(R.font.encode_sans_condensed_bold, FontWeight.Bold),
    Font(R.font.encode_sans_condensed_light, FontWeight.Light),
    Font(R.font.encode_sans_condensed_medium, FontWeight.Medium),
    Font(R.font.encode_sans_condensed_extra_bold, FontWeight.ExtraBold),
    Font(R.font.encode_sans_condensed_extra_light, FontWeight.ExtraLight),
    Font(R.font.encode_sans_condensed_regular, FontWeight.Normal),
    Font(R.font.encode_sans_condensed_semi_bold, FontWeight.SemiBold),
    Font(R.font.encode_sans_condensed_thin, FontWeight.Thin),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelLarge = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.Black,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    titleLarge = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.Black,
        fontSize = 14.sp
    ),
    titleMedium = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.Black,
        fontSize = 12.sp
    ),
    titleSmall = TextStyle(
        fontFamily = EncodeSans,
        fontWeight = FontWeight.Thin,
        fontSize = 12.sp
    )
)