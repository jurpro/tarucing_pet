package com.ujanglukmanbdg.tarucingpet.data

import com.ujanglukmanbdg.tarucingpet.model.Animal
import com.ujanglukmanbdg.tarucingpet.model.Owner
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class TarucingPetRepository {
    private val orderAnimal = mutableListOf<OrderAdopted>()
    private val allAnimals = mutableListOf<Animal>()

    fun getListAnimals(): Flow<List<Animal>> {
        return flowOf(SampleAnimalDataSource.animalList)
    }

    init {
        if (orderAnimal.isEmpty()) {
            SampleAnimalDataSource.animalList.forEach {
                orderAnimal.add(OrderAdopted(it, 0))
            }
        }
    }

    /*
    init {
        if (allAnimals.isEmpty()) {
            SampleAnimalDataSource.animalList.forEach {
                allAnimals.add(SampleAnimalDataSource.animalList(it, 0))
            }
        }
    }

    fun getAllAnimals(): Flow<List<OrderAdopted>> {
        return flowOf(SampleAnimalDataSource.animalList)
    } */

    fun getAllOwners(): Flow<List<Owner>> {
        return flowOf(SampleAnimalDataSource.ownerList)
    }

    fun getAnimalById(animalId: Int): Animal {
        return allAnimals.first {
            it.id == animalId
        }
    }

    fun updateOrderAdopted(animalId: Int, newCountValue: Int): Flow<Boolean> {
        val index = orderAnimal.indexOfFirst { it.animal.id == animalId }
        val result = if (index >= 0) {
            val orderAnimals = orderAnimal[index]
            orderAnimal[index] =
                orderAnimals.copy(
                    animal = orderAnimal[index].animal,
                    priceAdopted = newCountValue
                )
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderRewards(): Flow<List<Animal>> {
        return getListAnimals().map { allItems ->
            allItems.filter { item ->
                item.id != 0
            }
        }
    }

    companion object {
        @Volatile
        private var instance: TarucingPetRepository? = null

        fun getInstance(): TarucingPetRepository =
            instance ?: synchronized(this) {
                TarucingPetRepository().apply {
                    instance = this
                }
            }
    }
}