package com.ujanglukmanbdg.tarucingpet.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ujanglukmanbdg.tarucingpet.data.TarucingPetRepository
import com.ujanglukmanbdg.tarucingpet.data.UiState
import com.ujanglukmanbdg.tarucingpet.model.Animal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: TarucingPetRepository
) : ViewModel() {
    private val _uiStateAnimal: MutableStateFlow<UiState<List<Animal>>> = MutableStateFlow(UiState.Loading)

    val uiStateAnimal: StateFlow<UiState<List<Animal>>>
        get() = _uiStateAnimal

    fun getListAnimals() {
        viewModelScope.launch {
            repository.getListAnimals()
                .catch {
                    _uiStateAnimal.value = UiState.Error(it.message.toString())
                }
                .collect { listAnimals ->
                    _uiStateAnimal.value = UiState.Success(listAnimals)
                }
        }
    }
}