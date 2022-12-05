package com.uc.alp_vp_acleaning.retrofit

interface EndPointApi {
    @GET("/mahasiswa")
    suspend fun getMahasiswa()
}