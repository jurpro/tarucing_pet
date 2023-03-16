package com.ujanglukmanbdg.tarucingpet.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ujanglukmanbdg.tarucingpet.R
import com.ujanglukmanbdg.tarucingpet.component.PromotionHome
import com.ujanglukmanbdg.tarucingpet.component.SearchBar
import com.ujanglukmanbdg.tarucingpet.component.TopBar
import com.ujanglukmanbdg.tarucingpet.data.Injection
import com.ujanglukmanbdg.tarucingpet.data.UiState
import com.ujanglukmanbdg.tarucingpet.ui.ViewModelFactory


@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    modifier: Modifier = Modifier,
    HomeViewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ){
       item {
           Column(modifier = modifier.padding(8.dp)) {
               SearchBar()

               TopBar(navController = navController)

               Spacer(modifier = Modifier.height(4.dp))

               PromotionHome(navController = navController)
           }
       }
        item {
            HomeViewModel.uiStateAnimal.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> { HomeViewModel.getListAnimals() }
                    is UiState.Success -> {
                        ListPetHome(
                            modifier = Modifier.padding(
                                start = 16.dp,
                                end = 16.dp,
                                bottom = paddingValues.calculateBottomPadding()
                            ),
                            navController = navController,
                            animals = uiState.data
                        )
                    }
                    is UiState.Error -> { Text(text = stringResource(id = R.string.error)) }
                }
            }
        }
    }
}