package com.ujanglukmanbdg.tarucingpet.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ujanglukmanbdg.tarucingpet.R
import com.ujanglukmanbdg.tarucingpet.ui.theme.TarucingPetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier, ) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null ) },
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        placeholder = { Text(stringResource(R.string.placeholder_search)) },
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview(){
    TarucingPetTheme {
        SearchBar()
    }
}