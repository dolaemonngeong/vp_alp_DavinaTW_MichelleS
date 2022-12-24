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
import com.uc.alp_vp_acleaning.model.KecamatanItem
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.model.TechnicianItem
import com.uc.alp_vp_acleaning.repository.KecamatanRepository
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KecamatanViewModel @Inject constructor(private val repository: KecamatanRepository) :
    ViewModel() {

    //get Kecamatan
    val _kecamatan: MutableLiveData<ArrayList<KecamatanItem>> by lazy {
        MutableLiveData<ArrayList<KecamatanItem>>()
    }

    val technician: LiveData<ArrayList<KecamatanItem>> get() = _kecamatan

    fun getKecamatanData() = viewModelScope.launch {

        repository.getKecamatanResult().let { response ->
            //ikti movie
            if (response.isSuccessful) {
                _kecamatan.postValue(response.body()?.data as ArrayList<KecamatanItem>?)
            } else {
                Log.e("Get Data", "Failed!")
            }
        }
    }
}