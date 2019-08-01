package com.reyesmagos.routes

import com.reyesmagos.repository.ProductRepository
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing


class ProductRoute(
    private val application: Application,
    private val productRepository: ProductRepository
) {

    init {
        addGetProductsRoute()
    }

    private fun addGetProductsRoute() {
        application.routing {
            get(GET_PRODUCTS_ROUTE) {
                call.respond(productRepository.getProducts())
            }
        }
    }
}