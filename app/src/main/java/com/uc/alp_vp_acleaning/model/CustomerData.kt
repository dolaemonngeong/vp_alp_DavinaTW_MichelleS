package com.uc.alp_vp_acleaning.model

data class CustomerData (
    val `data` : Data,
    val message: String,
    val status: Int
){
    data class Data(val last_inserted_id: Int)
}

//    val message: String,
//    val status: Int
