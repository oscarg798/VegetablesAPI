package com.reyesmagos

import com.google.gson.Gson
import java.lang.reflect.Type

abstract class MockableTest {

    private val gson = Gson()

    fun <T> transformResponse(response: String, classType: Class<T>): T {
        return gson.fromJson(response, classType)
    }

    fun <T> transformResponseAsList(response: String, type: Type): List<T> {
        return Gson().fromJson(response, type)
    }
}