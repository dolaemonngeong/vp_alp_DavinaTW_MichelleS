// To parse the JSON, install Klaxon and do:
//
//   val technician = Technician.fromJson(jsonString)

package com.uc.alp_vp_acleaning.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

class Technician(elements: Collection<TechnicianElement>) : ArrayList<TechnicianElement>(elements) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = Technician(klaxon.parseArray<TechnicianElement>(json)!!)
    }
}

data class TechnicianElement (
    @Json(name = "t_id")
    val tID: Long,

    @Json(name = "t_name")
    val tName: String,

    val username: String,
    val phone: String,
    val email: String,
    val password: String,
    val rate: Long,

    @Json(name = "kecamatan_id")
    val kecamatanID: Long,

    val status: String
)
