package com.uc.alp_vp_acleaning.retrofit

import com.google.gson.JsonObject
import com.uc.alp_vp_acleaning.model.*
import retrofit2.Response
import retrofit2.http.*


interface EndPointApi {
    @POST("/login-techician")
    suspend fun loginTechnician(
        @Body technician: Technician
    ): Response<Technician>

    @GET("/technician-all")
    suspend fun getTechnician(
    ): Response<TechnicianData>

    @GET("/technician-by-id/{t_id}")
    suspend fun getTechnicianById(
        @Path("t_id") t_id: Int
    ): Response<TechnicianData1>

//    @GET("/technician-all")
//    suspend fun getTechnician1(
//    ): Response<JsonObject>

    @GET("/technician/{name}")
    suspend fun getTechnician(
        @Path("name") name : String
    ): Response<JsonObject>

    @GET("/technician-location/{k_id}")
    suspend fun getTechnician(
        @Path("k_id") k_id : Int
    ): Response<TechnicianData1>

    @PUT("/technician/{t_id}")
    suspend fun deleteteTechnician(
//        val c_id: Int,
//        val email: String,
//        val name: String,
//        val password: String,
//        val phone: String,
//        val status: String,
//        val username: String
        @Path ("t_id") t_id : Int
    ): Response<Technician>

    @POST("/technician")
    suspend fun createTechnician(
//        val c_id: Int,
//        val email: String,
//        val name: String,
//        val password: String,
//        val phone: String,
//        val status: String,
//        val username: String
        @Body technician: Technician
    ): Response<Technician>

    @PATCH("/technician/{t_id}")
    suspend fun updateTechnician(
//        val c_id: Int,
//        val email: String,
//        val name: String,
//        val password: String,
//        val phone: String,
//        val status: String,
//        val username: String
        @Body technician: Technician
    ): Response<Technician>

    @PATCH("/technician/{t_id}/{rete}")
    suspend fun updateRate(
//        val c_id: Int,
//        val email: String,
//        val name: String,
//        val password: String,
//        val phone: String,
//        val status: String,
//        val username: String
        @Path("t_id") t_id : Int,
        @Path("rate") rate : Int
    ): Response<Technician>

    @POST("/login-customer")
    suspend fun loginCustomer(
        @Body customer: Customer
    ): Response<Customer>

    @GET("/customer")
    suspend fun getCustomer(
    ): Response<JsonObject>

    @GET("/customer-by-id/{c_id}")
    suspend fun getCustomerByID(
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

    @PATCH("/customer/{c_id}")
    suspend fun updateCustomer(
//        val c_id: Int,
//        val email: String,
//        val name: String,
//        val password: String,
//        val phone: String,
//        val status: String,
//        val username: String
        @Body customer: Customer
    ): Response<Customer>

    @PUT("/customer/{c_id")
    suspend fun deleteteCustomer(
//        val c_id: Int,
//        val email: String,
//        val name: String,
//        val password: String,
//        val phone: String,
//        val status: String,
//        val username: String
//        @Body customer: Customer
    @Path("c_id") c_id : Int
    ): Response<Customer>

    @GET("/customer-order/{c_id}/{status}")
    suspend fun orderCustomer(
        @Path("c_id") c_id: Int,
    @Path("status") status : String
    ): Response<Order>

    @GET("/technician-order/{t_id}/{status}")
    suspend fun orderTechnician(
        @Path("t_id") t_id: Int,
    ): Response<Order>

    //semua order enda perlu tampaknya
//    @GET("/order")
//    suspend fun
//    ):Response<>

    @POST("/order")
    suspend fun createOrder(
        @Query("name") name :String,
        @Query("address") address :String,
        @Query("phone") phone :String,
        @Query("time") time :String,
//        @Body order: Order
    ):Response<Order>

    //update status order dr pending -> on-going -> completed
    @PATCH("/order")
    suspend fun updateOrder(

    ):Response<Order>

    @GET("/order-by-id/{o_id}")
    suspend fun orderDetail(
        @Path("o_id") o_id: Int
    ):Response<Order>

    @GET("/kecamatan")
    suspend fun getKecamatan (
    ):Response<KecamatanData1>

    @GET("/wilayah")
    suspend fun getWilayah (
        @Body wilayah : Wilayah
    ):Response<JsonObject>
}