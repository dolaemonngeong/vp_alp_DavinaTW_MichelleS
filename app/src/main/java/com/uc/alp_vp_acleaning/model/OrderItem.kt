package com.uc.alp_vp_acleaning.model

data class OrderItem(
    val Technician: TechnicianItem,
    val the0_id: Long,
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