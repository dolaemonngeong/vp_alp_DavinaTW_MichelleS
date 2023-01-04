package com.uc.alp_vp_acleaning.repository

import com.uc.alp_vp_acleaning.retrofit.EndPointApi
import javax.inject.Inject

class OrderRepository @Inject constructor(private val api: EndPointApi) {
//    suspend fun getOrderResult() = api.getOrderData()
    suspend fun getOrderTechStatus(t_id:Int, status:String) = api.orderTechnician(t_id,status)
    suspend fun getOrderCustomerStatus(c_id:Int, status:String) = api.orderCustomer(c_id,status)
    suspend fun getOrderDetailsData(o_id: Int) = api.getOrderById(o_id)

//    private fun convertJsonToTechnicians(json: JsonObject): List<Technician> {
//        val technicians = mutableListOf<Technician>()
//
//        // Extract the data from the JsonObject and create Technician objects
//        val jsonArray = json.getAsJsonArray("technicians")
//        for (i in 0 until jsonArray.size()) {
//            val jsonObject = jsonArray.get(i).getAsJsonObject()
//            val id = jsonObject.get("id").getAsInt()
//            val name = jsonObject.get("name").getAsString()
//            val rating = jsonObject.get("rating").getAsDouble()
//            val kecamatanId = jsonObject.get("kecamatan_id").getAsInt()
//            val kecamatanName = kecamatanIdToNameMap[kecamatanId] // Look up the kecamatan name using the mapping
//            val technician = Technician(id, name, rating, kecamatanId, kecamatanName) // Include the kecamatan name in the Technician object
//            technicians.add(technician)
//        }
//
//        return technicians
//    }

//    suspend fun getTechnicianResult(): List<TechnicianItem> {
//        val response = api.getTechnician().await()
//        val technicians = mutableListOf<TechnicianItem>()
//        val jsonArray = response.getAsJsonArray("technicians")
//        for (i in 0 until jsonArray.size()) {
//            val jsonObject = jsonArray.get(i).getAsJsonObject()
//            val id = jsonObject.get("id").getAsInt()
//            val name = jsonObject.get("name").getAsString()
//            val rating = jsonObject.get("rating").getAsDouble()
//            val kecamatanId = jsonObject.get("kecamatan_id").getAsInt()
//            val technician = TechnicianItem(id, name, rating, kecamatanId)
//            technicians.add(technician)
//        }
//        return technicians
//    }

//chat open ai tp eror di enqueue
//class TechnicianRepository @Inject constructor(
//    private val api: EndPointApi
//) {
//    fun getTechnicians(): LiveData<List<TechnicianItem>> {
//        val techniciansLiveData = MutableLiveData<List<TechnicianItem>>()
//        api.getTechnician().enqueue(object : Callback<JsonObject> {
//            override fun onResponse(
//                call: Call<JsonObject>,
//                response: Response<JsonObject>
//            ) {
//                if (response.isSuccessful) {
//                    val technicians = convertJsonToTechnicians(response.body())
//                    techniciansLiveData.value = technicians
//                }
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                techniciansLiveData.value = emptyList()
//            }
//        })
//        return techniciansLiveData
//    }
//
//    private fun convertJsonToTechnicians(json: JsonObject): List<TechnicianItem> {
//        val technicians = mutableListOf<TechnicianItem>()
//        val jsonArray = json.getAsJsonArray("technicians")
//        for (i in 0 until jsonArray.size()) {
//            val jsonObject = jsonArray.get(i).getAsJsonObject()
//            val email = jsonObject.get("email").getAsString()
//            val kecamatanId = jsonObject.get("kecamatan_id").getAsInt()
//            val password = jsonObject.get("password").getAsString()
//            val phone = jsonObject.get("phone").getAsString()
//            val rate = jsonObject.get("rate").getAsInt()
//            val status = jsonObject.get("status").getAsString()
//            val username = jsonObject.get("username").getAsString()
//            val t_id = jsonObject.get("t_id").getAsInt()
//            val t_name = jsonObject.get("t_name").getAsString()
//            val technician = TechnicianItem(email, kecamatanId, password, phone, rate, status, t_id, t_name, username)
//            technicians.add(technician)
//        }
//        return technicians
//    }
//}


}