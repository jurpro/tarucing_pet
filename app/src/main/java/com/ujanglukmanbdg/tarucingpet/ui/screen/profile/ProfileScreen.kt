package com.ujanglukmanbdg.tarucingpet.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ujanglukmanbdg.tarucingpet.R

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ujang_lukman_profile),
            contentDescription = stringResource(R.string.profile_tarucing_name),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            modifier = modifier
                .padding(8.dp)
                .border(4.dp, Color.Blue, CircleShape)
                .clip(CircleShape)
                .size(200.dp)
        )

        Spacer(modifier = modifier.fillMaxWidth().height(24.dp))

        Text(
            text = stringResource(R.string.profile_tarucing_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold),
            modifier = modifier.padding(8.dp)
        )

        Row(modifier = modifier.align(Alignment.Start)) {
            Icon(painter = painterResource(R.drawable.ic_man_with_tie_profile_svgrepo_com) , contentDescription = null)
            Spacer(modifier.padding(2.dp))
            Text(
                text = stringResource(R.string.profile_tarucing_name),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.ExtraBold),
                modifier = modifier.padding(8.dp)
            )
        }

        Row(modifier = modifier.align(Alignment.Start)) {
            Icon(painter = painterResource(R.drawable.ic_email_envelope_letter_mail_message_text_svgrepo_com) , contentDescription = null)
            Spacer(Modifier.padding(2.dp))
            Text(
                text = stringResource(R.string.profile_tarucing_email),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                modifier = modifier.padding(8.dp)
            )
        }
        Row(modifier = modifier.align(Alignment.Start)) {
            Icon(painter = painterResource(R.drawable.ic_maps_mark_symbol_svgrepo_com) , contentDescription = null)
            Spacer(modifier.padding(2.dp))
            Text(
                text = stringResource(R.string.profile_tarucing_address),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                modifier = modifier.padding(8.dp)
            )
        }
        Row(modifier = modifier.align(Alignment.Start)) {
            Icon(painter = painterResource(R.drawable.ic_quote_up_square_svgrepo_com) , contentDescription = null)
            Spacer(modifier.padding(2.dp))
            Text(
                text = stringResource(R.string.profile_tarucing_bio),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                modifier = modifier.padding(8.dp)
            )
        }
        Row(modifier = modifier.align(Alignment.Start)) {
            Icon(painter = painterResource(R.drawable.ic_favorite_button_svgrepo_com) , contentDescription = null)
            Spacer(modifier.padding(2.dp))
            Text(
                text = stringResource(R.string.profile_tarucing_favorite),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                modifier = modifier.padding(8.dp)
            )
        }
        Row(modifier = modifier.align(Alignment.Start)) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_animal_footprint_svgrepo_com), contentDescription = null)
            Spacer(modifier.padding(2.dp))
            Text(
                text = stringResource(R.string.profile_tarucing_favorite_animal),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                modifier = modifier.padding(8.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.tarucing_copyright),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                modifier = modifier.padding(8.dp)
            )
        }
    }
}