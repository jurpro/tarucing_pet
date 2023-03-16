package com.ujanglukmanbdg.tarucingpet.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ujanglukmanbdg.tarucingpet.R
import com.ujanglukmanbdg.tarucingpet.model.Animal
import com.ujanglukmanbdg.tarucingpet.navigation.ScreenMenu

@Composable
fun ItemAnimalCard(
    animal: Animal,
    navController: NavController,
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { navController.navigate(ScreenMenu.DetailAnimal.createRoute(id = animal.id)) },
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 0.4.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
    ){
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(animal.image)
                    .crossfade(true).build(),
                contentDescription = animal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = animal.name,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.labelLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = buildString {
                        append(animal.age)
                        append(" yrs | ")
                        append(animal.gender) },
                    modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.labelMedium
                )

                Row(verticalAlignment = Alignment.Bottom) {
                    val location: Painter = painterResource(id = R.drawable.ic_location_animal)
                    Icon(
                        painter = location,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp, 16.dp),
                        tint = Color.Red
                    )

                    Text(
                        text = animal.location,
                        modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 0.dp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(8.dp, 0.dp, 8.dp, 0.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    GenderTag(animal.gender)

                    Spacer(modifier = Modifier.height(6.dp))

                    TypeAnimalTag(animal.type)
                }
            }
        }
    }
}

// Jika diperlukan untuk preview dibuka kembali composable preview.

/*
@Preview(showBackground = true)
@Composable
fun ItemAnimalCardPreview(){
    TarucingPetTheme {
        ItemAnimalCard(
            animal = Animal(
                id = 1,
                type = "Cat",
                name = "Joni",
                age = 2.85,
                gender = stringResource(id = R.string.animal_gender_2),
                color = "Blue Safir",
                weight = 4.0,
                health = "Good",
                location = "Ciendog City",
                image = R.drawable.kucing_satu_10,
                description = stringResource(R.string.animal_description_1),
                owner = Owner(
                    id = 1,
                    name = stringResource(R.string.owner_name_1),
                    bio = stringResource(R.string.owner_bio_1),
                    address = stringResource(R.string.owner_address_1),
                    image = R.drawable.julia_roberts_glam_squad
                )
            ),
             onItemClicked = { }
        )
    }
} */