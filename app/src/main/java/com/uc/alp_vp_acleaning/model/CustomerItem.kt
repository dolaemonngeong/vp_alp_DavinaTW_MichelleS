package com.uc.alp_vp_acleaning.model

data class CustomerItem(
    val c_id: Int,
    val email: String,
    val name: String,
    val password: String,
    val phone: String,
    val status: String,
    val username: String
)