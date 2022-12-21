package com.uc.alp_vp_acleaning.repository

import com.uc.alp_vp_acleaning.retrofit.EndPointApi
import javax.inject.Inject

class TechnicianRepository @Inject constructor(private val api: EndPointApi) {
    suspend fun getTechnicianResult() = api.getTechnician()


}