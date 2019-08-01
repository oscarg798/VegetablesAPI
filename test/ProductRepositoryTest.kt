package com.reyesmagos

import com.reyesmagos.models.Product
import com.reyesmagos.repository.ProductRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldEqual
import org.junit.Test

class ProductRepositoryTest {

    @Test
    fun `should get products`() {
        //Given
        val repository = ProductRepositoryImpl()

        //Whenever
        val result = runBlocking {
            repository.getProducts()
        }

        //Then
        result shouldEqual listOf(Product("1", "Apple", "Red and beautiful apples", listOf(), 1234))
    }
}