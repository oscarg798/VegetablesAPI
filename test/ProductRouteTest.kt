package com.reyesmagos

import com.google.gson.reflect.TypeToken
import com.reyesmagos.models.Product
import com.reyesmagos.routes.GET_PRODUCTS_ROUTE
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.amshove.kluent.shouldEqual
import org.junit.Test
import java.util.*


class ProductRouteTest : MockableTest() {

    private var productListType = object : TypeToken<ArrayList<Product>>() {}.type

    @Test
    fun `should get status ok when route is invoke`() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, GET_PRODUCTS_ROUTE).apply {
                HttpStatusCode.OK shouldEqual response.status()!!
            }
        }
    }

    @Test
    fun `should a list with one product`() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, GET_PRODUCTS_ROUTE).apply {
                transformResponseAsList<Product>(response.content!!, productListType) shouldEqual listOf(
                    Product(
                        "1",
                        "Apple",
                        "Red and beautiful apples",
                        listOf(),
                        1234
                    )
                )
            }
        }
    }
}