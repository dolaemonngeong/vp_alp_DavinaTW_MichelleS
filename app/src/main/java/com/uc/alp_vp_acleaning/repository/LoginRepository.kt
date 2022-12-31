package com.uc.alp_vp_acleaning.repository

import com.uc.alp_vp_acleaning.model.LoginRequest
import com.uc.alp_vp_acleaning.retrofit.EndPointApi
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: EndPointApi) {

    suspend fun loginTechnician(loginRequest: LoginRequest) = api.loginTechnician(loginRequest)

    suspend fun loginCustomer(loginRequest: LoginRequest) = api.loginCustomer(loginRequest.username, loginRequest.password)
}