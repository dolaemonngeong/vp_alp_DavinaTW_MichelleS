package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.model.TechnicianElement
import com.uc.alp_vp_acleaning.model.TechnicianItem
import com.uc.alp_vp_acleaning.repository.CustomerRepository
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TechnicianViewModel @Inject constructor(private val repository: TechnicianRepository):
    ViewModel(){


        //get Technician
        val _technician:MutableLiveData<ArrayList<TechnicianElement>> by lazy{
            MutableLiveData<ArrayList<TechnicianElement>>()
        }

        val technician: LiveData<ArrayList<TechnicianElement>> get() = _technician

//    private val _technicians = MutableLiveData<List<TechnicianItem>>()
//    val technicians: LiveData<List<TechnicianItem>>
//        get() = _technicians

    fun getTechnicianData() = viewModelScope.launch {

        repository.getTechnicianResult().let {
            response ->
            //ikti movie
            if (response.isSuccessful){
                _technician.postValue(response.body() as
                        ArrayList<TechnicianElement>)
            } else{
                Log.e("Get Data", "Failed!")
            }

            //json
//            if(response.isSuccessful){
//                _technician.value = response.body()
//                val array: JsonArray = _technician.value!!.getAsJsonArray("data")
//                    for(jsonObj in array){
//                        var mMineUserEntity:Technician = Gson().fromJson(jsonObj, Technician::class.java)
//                        Log.e("Test1", jsonObj.asJsonObject["name"].toString())
//                    }
//
//            }else{
//                Log.e("Get Technician Data","Failed!")
//            }
        }
    }

    //web johncodeos
//        fun getTechnicianData1(){
//            CoroutineScope(Dispatchers.IO).launch{
//                val response = repository.getTechnicianResult()
//
//                withContext(Dispatchers.Main){
//                    if(response.isSuccessful){
//                        val gson = GsonBuilder().setPrettyPrinting().create()
//                        val prettyJson = gson.toJson(
//                            JsonParser.parseString(
//                                response.body()
//                                    ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
//                            )
//                        )
//                        Log.e("Pretty Printed JSON :", prettyJson)
//
//                    }else{
//                        Log.e("RETROFIT_ERROR", response.code().toString())
//                    }
//                }
//            }
//        }

    }
