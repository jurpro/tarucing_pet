package com.ujanglukmanbdg.tarucingpet.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ujanglukmanbdg.tarucingpet.R

@Composable
fun TypeAnimalTag(name: String) {

    val color = if ( name == "cat") {
        R.color.cat_color
    } else {
        if ( name == "dog") {
            R.color.dog_color
        } else {
            if ( name == "bird") {
                R.color.bird_color
            } else {
                if ( name == "snake") {
                    R.color.snake_color
                } else {
                    R.color.other_color
                }
            }
        }
    }

    ChipViewType(
        type = name,
        colorResource = colorResource(id = color)
    )
}

@Composable
fun ChipViewType(type: String, colorResource: Color) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
            .clickable { Toast.makeText(context, R.string.clickable_dev_detail, Toast.LENGTH_LONG).show() },
    ) {
        Text(
            text = type,
            modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp).width(75.dp),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            color = colorResource
        )
    }
}