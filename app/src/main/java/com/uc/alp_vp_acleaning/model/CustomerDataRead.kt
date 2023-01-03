package com.uc.alp_vp_acleaning.model

data class CustomerDataRead (
    val `data`: List<CustomerItem>,
    val message: String,
    val status: Int
)