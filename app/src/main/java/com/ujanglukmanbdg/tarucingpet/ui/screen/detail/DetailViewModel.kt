package com.ujanglukmanbdg.tarucingpet.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ujanglukmanbdg.tarucingpet.data.TarucingPetRepository
import com.ujanglukmanbdg.tarucingpet.data.UiState
import com.ujanglukmanbdg.tarucingpet.model.Animal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: TarucingPetRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Animal>> =
        MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<Animal>> get() = _uiState

    fun getAnimalById(id: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getAnimalById(animalId = id))
        }
    }

    fun getDataAnimalById(id: Int): Animal {
        return repository.getAnimalById(animalId = id)
    }
}