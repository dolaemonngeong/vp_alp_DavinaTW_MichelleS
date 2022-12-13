package com.uc.alp_vp_acleaning.retrofit

import com.google.gson.JsonObject
import com.uc.alp_vp_acleaning.model.Customer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EndPointApi {
    @GET("/customer")
    suspend fun getCustomer(
    ): Response<JsonObject>

    @POST("/customer")
    suspend fun createCustomer(
//        val c_id: Int,
//        val email: String,
//        val name: String,
//        val password: String,
//        val phone: String,
//        val status: String,
//        val username: String
        @Body customer: Customer
    ): Response<Customer>
}