package com.ujanglukmanbdg.tarucingpet.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ujanglukmanbdg.tarucingpet.data.OrderAdopted
import com.ujanglukmanbdg.tarucingpet.data.TarucingPetRepository
import com.ujanglukmanbdg.tarucingpet.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val repository: TarucingPetRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<FavoriteState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<FavoriteState>>
        get() = _uiState

    /*
    fun getAddedOrderRewards() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderRewards()
                .collect { orderAdopted ->
                    val totalRequiredPoint =
                        orderAdopted.sumOf { it.animal.id * it.priceAdopted }
                    _uiState.value = UiState.Success(FavoriteState(orderAdopted, totalRequiredPoint))
                }
        }
    }

    fun updateOrderReward(rewardId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateOrderAdopted(rewardId.toInt(), count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderRewards()
                    }
                }
        }
    } */
}