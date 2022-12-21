// To parse the JSON, install Klaxon and do:
//
//   val order = Order.fromJson(jsonString)

package com.uc.alp_vp_acleaning.model

import com.beust.klaxon.*

private fun <T> Klaxon.convert(k: kotlin.reflect.KClass<*>, fromJson: (JsonValue) -> T, toJson: (T) -> String, isUnion: Boolean = false) =
    this.converter(object: Converter {
        @Suppress("UNCHECKED_CAST")
        override fun toJson(value: Any)        = toJson(value as T)
        override fun fromJson(jv: JsonValue)   = fromJson(jv) as Any
        override fun canConvert(cls: Class<*>) = cls == k.java || (isUnion && cls.superclass == k.java)
    })

private val klaxon = Klaxon()
    .convert(StringEnum::class, { StringEnum.fromValue(it.string!!) }, { "\"${it.value}\"" })
    .convert(Status::class,     { Status.fromValue(it.string!!) },     { "\"${it.value}\"" })

class Order(elements: Collection<OrderElement>) : ArrayList<OrderElement>(elements) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = Order(klaxon.parseArray<OrderElement>(json)!!)
    }
}

data class OrderElement (
    @Json(name = "0_id")
    val the0_ID: Long,

    val name: String,
    val address: String,
    val phone: String,
    val time: String,
    val date: String,
    val note: NoteClass,

    @Json(name = "t_id")
    val tID: Long,

    @Json(name = "c_id")
    val cID: Long,

    val status: Status
)

data class NoteClass (
    @Json(name = "String")
    val string: StringEnum,

    @Json(name = "Valid")
    val valid: Boolean
)

enum class StringEnum(val value: String) {
    DiDepanIndomaret("di depan indomaret"),
    Empty(""),
    T("t"),
    Tess("tess");

    companion object {
        public fun fromValue(value: String): StringEnum = when (value) {
            "di depan indomaret" -> DiDepanIndomaret
            ""                   -> Empty
            "t"                  -> T
            "tess"               -> Tess
            else                 -> throw IllegalArgumentException()
        }
    }
}

enum class Status(val value: String) {
    Completed("Completed"),
    Empty(""),
    OnGoing("On-going"),
    Pending("Pending");

    companion object {
        public fun fromValue(value: String): Status = when (value) {
            "Completed" -> Completed
            ""          -> Empty
            "On-going"  -> OnGoing
            "Pending"   -> Pending
            else        -> throw IllegalArgumentException()
        }
    }
}
