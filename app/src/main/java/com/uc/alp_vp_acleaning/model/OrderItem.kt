package com.uc.alp_vp_acleaning.model

data class OrderItem(
    val Technician: TechnicianItem,
    val o_id: Int,
    val name: String,
    val address: String,
    val phone: String,
    val time: String,
    val date: String,
    val note: Note,
    val t_id: Int,
    val c_id: Int,
    val status: String
)