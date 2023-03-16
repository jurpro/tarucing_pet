package com.ujanglukmanbdg.tarucingpet.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ujanglukmanbdg.tarucingpet.ui.theme.TarucingPetTheme
import com.ujanglukmanbdg.tarucingpet.R

@Composable
fun AnimalInfoCard(name: String, gender: String, type: String, update: String, location: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = name,
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.Bottom) {

                val locationIcon: Painter = painterResource(id = R.drawable.ic_location_animal)

                Icon(
                    painter = locationIcon,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp, 16.dp),
                    tint = Color.Red
                )

                Text(
                    text = location,
                    modifier = Modifier.padding(8.dp, 12.dp, 12.dp, 0.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = update,
                modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Column(
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp, 0.dp, 8.dp, 0.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TypeAnimalTag(type)

                Spacer(modifier = Modifier.height(8.dp))

                GenderTag(gender)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalInfoCardPreview(){
    TarucingPetTheme {
        AnimalInfoCard(
            name = "Kokom", gender = "female", type = "cat", update = "1 hour ago", location = "Banyumas"
        )
    }
}