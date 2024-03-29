package com.uc.alp_vp_acleaning.repository

import com.uc.alp_vp_acleaning.retrofit.EndPointApi
import javax.inject.Inject

class KecamatanRepository @Inject constructor(private val api: EndPointApi) {
    suspend fun getKecamatanResult() = api.getKecamatan()

}