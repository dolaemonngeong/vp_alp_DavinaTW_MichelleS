package com.uc.alp_vp_acleaning.repository

import com.uc.alp_vp_acleaning.retrofit.EndPointApi
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: EndPointApi) {

    fun loginCust(username: String, password: String) = api.loginCustomer(username, password)

    suspend fun getCustById(c_id: Int) = api.getCustomerByID(c_id)

}