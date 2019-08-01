package com.reyesmagos.repository

import com.reyesmagos.models.Product

class ProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return listOf(Product("1", "Apple", "Red and beautiful apples", listOf(), 1234))
    }
}