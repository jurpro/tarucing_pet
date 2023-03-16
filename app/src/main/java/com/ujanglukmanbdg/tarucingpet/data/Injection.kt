package com.ujanglukmanbdg.tarucingpet.data

object Injection {
    fun provideRepository(): TarucingPetRepository {
        return TarucingPetRepository.getInstance()
    }

    fun provideDetailAnimalRepository(): TarucingPetRepository {
        return TarucingPetRepository.getInstance()
    }
}