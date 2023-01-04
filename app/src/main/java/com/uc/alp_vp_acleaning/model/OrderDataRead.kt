package com.uc.alp_vp_acleaning.model

data class OrderDataRead(
    val `data`: List<OrderItem>,
    val message: String,
    val status: Int
)