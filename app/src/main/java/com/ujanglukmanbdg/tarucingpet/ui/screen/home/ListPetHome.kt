package com.ujanglukmanbdg.tarucingpet.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ujanglukmanbdg.tarucingpet.component.ItemAnimalCard
import com.ujanglukmanbdg.tarucingpet.model.Animal
import com.ujanglukmanbdg.tarucingpet.R

@Composable
fun ListPetHome(
    modifier: Modifier = Modifier,
    navController: NavController,
    animals: List<Animal>
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.padding(2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_more_vertical_square_svgrepo_com),
                contentDescription = stringResource(id = R.string.list_pet_home_celebrity_more),
            )

            Text(
                text = stringResource(id = R.string.list_pet_home_celebrity),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(2.dp),
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        animals.forEachIndexed { _, animal ->
            ItemAnimalCard(
                animal = animal,
                navController = navController
            )
            Spacer(modifier = Modifier.height(0.dp))
        }
    }
}