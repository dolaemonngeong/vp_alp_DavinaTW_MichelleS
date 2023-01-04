package com.uc.alp_vp_acleaning.model

data class OrderData(
    val `data`: Data,
    val message: String,
    val status: Int
){
    data class Data(val last_inserted_id: Int)
}