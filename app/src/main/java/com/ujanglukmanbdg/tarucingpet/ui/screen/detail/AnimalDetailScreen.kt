package com.ujanglukmanbdg.tarucingpet.ui.screen.detail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ujanglukmanbdg.tarucingpet.ui.theme.TarucingPetTheme
import com.ujanglukmanbdg.tarucingpet.R
import com.ujanglukmanbdg.tarucingpet.component.AnimalInfoCard
import com.ujanglukmanbdg.tarucingpet.component.OwnerInfoCard
import com.ujanglukmanbdg.tarucingpet.component.PetInfoCard
import com.ujanglukmanbdg.tarucingpet.data.SampleAnimalDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalDetailScreen(
    navController: NavController,
    id: Int,
){
    val context = LocalContext.current
    val animal = SampleAnimalDataSource.animalList[id-1]

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(animal.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Medium),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    ) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
            )
        },

        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surface),
            ) {

                // Basic details
                item {
                    animal.apply {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(animal.image)
                                .crossfade(true).build(),
                            contentDescription = animal.name,
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(346.dp)
                                .clip(shape = RoundedCornerShape(16.dp))
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        AnimalInfoCard(name, gender, type, update, location)
                    }
                }

                // Pet info
                item {
                    animal.apply {
                        Spacer(modifier = Modifier.height(12.dp))
                        Title(title = stringResource(id = R.string.detail_animal_info))
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp, 0.dp, 8.dp, 0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            PetInfoCard(title = stringResource(id = R.string.detail_animal_info_age), value = animal.age.toString().plus(" yrs"))
                            PetInfoCard(title = stringResource(id = R.string.detail_animal_info_color), value = color)
                            PetInfoCard(title = stringResource(id = R.string.detail_animal_info_weight), value = weight.toString().plus(" Kg"))
                            PetInfoCard(title = stringResource(id = R.string.detail_animal_info_health), value = health)
                        }
                    }
                }

                // Description details
                item {
                    animal.apply {
                        Spacer(modifier = Modifier.height(12.dp))
                        Title(title = "Description")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = description,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 0.dp, 16.dp, 0.dp),
                            color = colorResource(id = R.color.text),
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Start
                        )
                    }
                }

                // Owner info
                item {
                    animal.apply {
                        Spacer(modifier = Modifier.height(12.dp))
                        Title(title = "Owner info")
                        Spacer(modifier = Modifier.height(8.dp))
                        owner.apply {
                            OwnerInfoCard(name, bio, address, image)
                        }
                    }
                }

                // Button Multi function
                item {
                    Spacer(modifier = Modifier.height(36.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .padding(16.dp, 0.dp, 16.dp, 0.dp),
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        onClick = { Toast.makeText(context, R.string.clickable_dev_detail, Toast.LENGTH_LONG).show() },
                    ) {
                        Text(stringResource(id = R.string.detal_animal_button_play))
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }

                //Copyright
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.tarucing_copyright),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    )
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 0.dp, 0.dp),
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
}

@Preview(showBackground = true)
@Composable
fun AnimalDetailPreview(){
    TarucingPetTheme {
       // AnimalDetailScreen(id = 3, navController = { })
    }
}