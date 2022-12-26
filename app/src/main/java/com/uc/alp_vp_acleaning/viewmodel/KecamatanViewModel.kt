package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.KecamatanItem1
import com.uc.alp_vp_acleaning.repository.KecamatanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KecamatanViewModel @Inject constructor(private val repository: KecamatanRepository) :
    ViewModel() {

    //get Kecamatan
    val _kecamatan: MutableLiveData<ArrayList<KecamatanItem1>> by lazy {
        MutableLiveData<ArrayList<KecamatanItem1>>()
    }

    val technician: LiveData<ArrayList<KecamatanItem1>> get() = _kecamatan

    fun getKecamatanData() = viewModelScope.launch {

        repository.getKecamatanResult().let { response ->
            //ikti movie
            if (response.isSuccessful) {
                _kecamatan.postValue(response.body()?.data as ArrayList<KecamatanItem1>?)
            } else {
                Log.e("Get Data", "Failed!")
            }
        }
    }
}