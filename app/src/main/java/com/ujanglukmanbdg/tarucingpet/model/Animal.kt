package com.ujanglukmanbdg.tarucingpet.model

data class Animal(
    val id: Int,
    val type: String,
    val name: String,
    val age: Double,
    val gender: String,
    val color: String,
    val weight: Double,
    val health: String,
    val location: String,
    val image: Int,
    val description: String,
    val update: String,
    val owner: Owner
)
