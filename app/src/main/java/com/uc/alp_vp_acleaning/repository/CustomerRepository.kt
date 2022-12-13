package com.uc.alp_vp_acleaning.repository

import com.uc.alp_vp_acleaning.model.Customer
import com.uc.alp_vp_acleaning.retrofit.EndPointApi
import retrofit2.http.Body
import javax.inject.Inject

class CustomerRepository @Inject constructor(private  val api: EndPointApi){
    suspend fun getCustomerResult() = api.getCustomer()

    suspend fun createCustomerResult(c:Customer) = api.createCustomer(c)
}