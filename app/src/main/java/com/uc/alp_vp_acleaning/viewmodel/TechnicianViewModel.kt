package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.TechnicianItem
import com.uc.alp_vp_acleaning.model.TechnicianItem1
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TechnicianViewModel @Inject constructor(private val repository: TechnicianRepository):
    ViewModel(){

        //get Technician
        val _technician:MutableLiveData<ArrayList<TechnicianItem>> by lazy{
            MutableLiveData<ArrayList<TechnicianItem>>()
        }

        val technician: LiveData<ArrayList<TechnicianItem>> get() = _technician

    fun getTechnicianData() = viewModelScope.launch {

        repository.getTechnicianResult().let {
            response ->
            //ikti movie
            if (response.isSuccessful){
                _technician.postValue(response.body()?.data as ArrayList<TechnicianItem>?)
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


    //Get Technician Details Data
    val _technicianDetails: MutableLiveData<ArrayList<TechnicianItem>> by lazy {
        MutableLiveData<ArrayList<TechnicianItem>>()
    }

    val technicianDetails: LiveData<ArrayList<TechnicianItem>>
        get() = _technicianDetails

    fun getTechnicianDetails(t_id: Int) = viewModelScope.launch {
        repository.getTechnicianDetailsData(t_id).let {
                response ->
            if (response.isSuccessful){
                _technicianDetails.postValue(response.body()?.data as ArrayList<TechnicianItem>?)
            } else{
                Log.e("Get Movie Details Data", "Failed!")
            }
        }
    }

    }
