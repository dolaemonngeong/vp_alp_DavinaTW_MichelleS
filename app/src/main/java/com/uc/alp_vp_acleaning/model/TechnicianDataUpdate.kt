package com.uc.alp_vp_acleaning.model

data class TechnicianDataUpdate(
    val `data`: Data,
    val message: String,
    val status: Int
){
    data class Data(val row_affected: Int)
}