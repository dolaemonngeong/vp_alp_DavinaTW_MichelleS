package com.uc.alp_vp_acleaning.repository

import com.uc.alp_vp_acleaning.model.CustomerItem
import com.uc.alp_vp_acleaning.retrofit.EndPointApi
import javax.inject.Inject

class CustomerRepository @Inject constructor(private  val api: EndPointApi){
    suspend fun getCustomerResult(username: String, password: String) = api.getCustomer()

    suspend fun createCustomerResult(c:CustomerItem) = api.createCustomer(c.c_id, c.email, c.name, c.password, c.phone, c.status, c.username)
    suspend fun getUserById(cId: Int) {
        api.getCustomerByID(cId)
    }
}