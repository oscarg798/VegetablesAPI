package com.reyesmagos.repository

import com.reyesmagos.models.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>
}