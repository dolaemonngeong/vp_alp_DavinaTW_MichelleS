package com.uc.alp_vp_acleaning.model

data class TechnicianItem1(
    val email: String,
//    val kecamatan_id: List<KecamatanItem>,
    val kecamatan_id: Int,
    val password: String,
    val phone: String,
    val rate: String,
    val status: String,
    val t_id: Int,
    val t_name: String,
    val username: String,
)