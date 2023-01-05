package com.uc.alp_vp_acleaning.retrofit

import com.google.gson.JsonObject
import com.uc.alp_vp_acleaning.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface EndPointApi {
    @FormUrlEncoded
    @POST("/login-technician")
    fun loginTechnician(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Call<LoginRequestTech>

    @GET("/technician-all")
    suspend fun getTechnician(
    ): Response<TechnicianData>

    @GET("/technician-by-id/{t_id}")
    suspend fun getTechnicianById(
        @Path("t_id") t_id: Int
    ): Response<TechnicianItem>

//    @GET("/technician-all")
//    suspend fun getTechnician1(
//    ): Response<JsonObject>

    @GET("/technician/{name}")
    suspend fun getTechnician(
        @Path("name") name: String
    ): Response<JsonObject>

    @GET("/technician-location/{k_id}")
    suspend fun getTechnician(
        @Path("k_id") k_id: Int
    ): Response<TechnicianData>

    @PUT("/technician/{t_id}")
    suspend fun deleteTechnician(
        @Path("t_id") t_id: Int
    ): Response<TechnicianData>

    @POST("/technician")
    suspend fun createTechnician(
        @Body technician: Technician
    ): Response<Technician>

    @PATCH("/technician/{t_id}")
    suspend fun updateTechnician(
        @Body technician: Technician
    ): Response<Technician>

    @PATCH("/technician/{t_id}/{rete}")
    suspend fun updateRate(
        @Path("t_id") t_id: Int,
        @Path("rate") rate: Int
    ): Response<Technician>

    @FormUrlEncoded
    @POST("/login-customer")
    fun loginCustomer(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Call<LoginRequestCust>

    @GET("/customer")
    suspend fun getCustomer(
    ): Response<JsonObject>

    @GET("/customer-by-id/{c_id}")
    suspend fun getCustomerByID(
        @Path("c_id") c_id: Int
    ): Response<CustomerItem>

    @FormUrlEncoded
    @POST("/customer")
    suspend fun createCustomer(
        @Field("c_id") c_id: String,
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("phone") phone: String,
        @Field("status") status: String,
        @Field("username") username: String
    )
            : Response<CustomerData>
//    @POST
//    Fun... () {
//        @Field("c_id") c_id: String,
//        ...
//    }: Response<... >

    @PATCH("/customer/{c_id}")
    suspend fun updateCustomer(
        @Body customer: Customer
    ): Response<Customer>

    @PUT("/customer/{c_id")
    suspend fun deleteCustomer(
        @Path("c_id") c_id: Int
    ): Response<Customer>

    @GET("/customer-order/{c_id}/{status}")
    suspend fun orderCustomer(
        @Path("c_id") c_id: Int,
        @Path("status") status: String
    ): Response<OrderDataRead>

    @GET("/technician-order/{t_id}/{status}")
    suspend fun orderTechnician(
        @Path("t_id") t_id: Int,
        @Path("status") status: String
    ): Response<OrderDataRead>

    //semua order enda perlu tampaknya
//    @GET("/order")
//    suspend fun
//    ):Response<>

    @FormUrlEncoded
    @POST("/order")
    suspend fun createOrder(
        @Field("o_id") o_id: String,
        @Field("name") name: String,
        @Field("address") address: String,
        @Field("phone") phone: String,
        @Field("time") time: String,
        @Field("date") date: String,
        @Field("note") note: String,
        @Field("t_id") t_id: Int,
        @Field("c_id") c_id: Int,
        @Field("status") status: String,
    ): Response<OrderData>

    //update status order dr pending -> on-going -> completed
    @FormUrlEncoded
    @PATCH("/order")
    suspend fun updateOrder(
        @Field("o_id") o_id: String,
        @Field("status") status: String,
    ): Response<OrderDataUpdate>

//    @GET("/order-all")
//    suspend fun getOrderData(
//    ): Response<OrderDataRead>

    @GET("/order-by-id/{o_id}")
    suspend fun getOrderById(
        @Path("o_id") o_id: Int
    ): Response<OrderItem>

    @GET("/kecamatan")
    suspend fun getKecamatan(
    ): Response<KecamatanData1>

    @GET("/wilayah")
    suspend fun getWilayah(
        @Body wilayah: Wilayah
    ): Response<JsonObject>
}