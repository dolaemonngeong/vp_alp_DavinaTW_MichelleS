package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.uc.alp_vp_acleaning.model.Kecamatan
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.repository.KecamatanRepository
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KecamatanViewModel @Inject constructor(private val repository: KecamatanRepository):
    ViewModel(){

    //get Kecamatan
    val _kecamatan:MutableLiveData<JsonObject> by lazy{
        MutableLiveData<JsonObject>()
    }

    val kecamatan: LiveData<JsonObject> get() = _kecamatan

    fun getKecamatanData() = viewModelScope.launch {
        repository.getKecamatanResult().let {
                response ->
            if(response.isSuccessful){
                _kecamatan.value = response.body()
                val array: JsonArray = _kecamatan.value!!.getAsJsonArray("data")
                for(jsonObj in array){
                    var mMineUserEntity: Kecamatan = Gson().fromJson(jsonObj, Kecamatan::class.java)
                    Log.e("Test1", jsonObj.asJsonObject["nama"].toString())
                }

            }else{
                Log.e("Get Technician Data","Failed!")
            }
        }
    }
}