// To parse the JSON, install Klaxon and do:
//
//   val kecamatan = Kecamatan.fromJson(jsonString)

package com.uc.alp_vp_acleaning.model

import com.beust.klaxon.*

private val klaxon = Klaxon()

class Kecamatan1(elements: Collection<KecamatanElement>) : ArrayList<KecamatanElement>(elements) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = Kecamatan1(klaxon.parseArray<KecamatanElement>(json)!!)
    }
}

data class KecamatanElement (
    @Json(name = "k_id")
    val kID: Long,

    @Json(name = "kecamatan_name")
    val kecamatanName: String,

    @Json(name = "wilayah_id")
    val wilayahID: Long
)
