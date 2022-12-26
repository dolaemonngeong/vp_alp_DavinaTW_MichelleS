package com.uc.alp_vp_acleaning.model

data class TechnicianData(
    val `data`: List<TechnicianItem>,
    val message: String,
    val status: Int
)