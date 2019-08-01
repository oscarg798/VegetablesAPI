package com.reyesmagos.models

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val images: List<String>,
    val price: Long
)