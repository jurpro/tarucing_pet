package com.ujanglukmanbdg.tarucingpet.ui.screen.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ujanglukmanbdg.tarucingpet.component.MessageCard
import com.ujanglukmanbdg.tarucingpet.data.CelebrityChat
import com.ujanglukmanbdg.tarucingpet.data.SampleDataChat
import com.ujanglukmanbdg.tarucingpet.ui.theme.TarucingPetTheme

@Composable
fun CelebrityChatScreen(
    message: List<CelebrityChat>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth().fillMaxHeight().padding(paddingValues = PaddingValues(all = 8.dp))
    ) {
        items(message) {
                message -> MessageCard(message)
        }
    }
}

@Preview
@Composable
fun CelebrityChatScreenPreview() {
    TarucingPetTheme {
        CelebrityChatScreen(SampleDataChat.conversationSample)
    }
}