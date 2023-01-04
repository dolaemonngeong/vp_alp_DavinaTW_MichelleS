package com.uc.alp_vp_acleaning.model

data class OrderItemCreate(
    val o_id: String,
    val name: String,
    val address: String,
    val phone: String,
    val time: String,
    val date: String,
    val note: String,
    val t_id: Int,
    val c_id: Int,
    val status: String
)