package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.repository.CustomerRepository
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TechnicianViewModel @Inject constructor(private val repository: TechnicianRepository):
    ViewModel(){

        //get Technician
        private val _technician:MutableLiveData<Technician> by lazy{
            MutableLiveData<Technician>()
        }

        val technician: LiveData<Technician> get() =_technician

    fun getTechnicianData() = viewModelScope.launch {
        repository.getTechnicianResult().let {
            response ->
            if(response.isSuccessful){
                _technician.postValue(response.body() as Technician)
            }else{
                Log.e("Get Technician Data","Failed!")
            }
        }
    }
    }
