package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.*
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TechnicianViewModel @Inject constructor(private val repository: TechnicianRepository) :
    ViewModel() {

    //get Technician
    val _technician: MutableLiveData<ArrayList<TechnicianItem>> by lazy {
        MutableLiveData<ArrayList<TechnicianItem>>()
    }

    val technician: LiveData<ArrayList<TechnicianItem>> get() = _technician

    fun getTechnicianData() = viewModelScope.launch {

        repository.getTechnicianResult().let { response ->
            //ikti movie
            if (response.isSuccessful) {
                _technician.postValue(response.body()?.data as ArrayList<TechnicianItem>?)
            } else {
                Log.e("Get Data", "Failed!")
            }
        }
    }

    fun getTechName(t_name: String) = viewModelScope.launch {

        repository.searchTechData(t_name).let { response ->
            //ikti movie
            if (response.isSuccessful) {
                _technician.postValue(response.body()?.data as ArrayList<TechnicianItem>?)
            } else {
                Log.e("Get Data", "Failed!")
            }
        }
    }

    fun getTechFilterData(k_id: Int) = viewModelScope.launch {
        Log.d("order cust status vm", "msk")
        try {
            repository.getTechnicianLocation(k_id).let { response ->
                if (response.isSuccessful) {
                    Log.d("order cust status vm resp", "msk resp")

                    _technician.postValue(response.body()?.data as ArrayList<TechnicianItem>?)

                } else {
                    Log.e("Get Data", "Failed!")
                }


            }
        } catch (e: Exception) {
            Log.e("order cust status vm resp", e.toString())
        }
    }

    //Get Technician Details Data
    val _technicianDetails: MutableLiveData<TechnicianItem> by lazy {
        MutableLiveData<TechnicianItem>()
    }

    val technicianDetails: LiveData<TechnicianItem>
        get() = _technicianDetails

    fun getTechnicianDetails(t_id: Int) = viewModelScope.launch {
        repository.getTechnicianDetailsData(t_id).let { response ->
            if (response.isSuccessful) {
                _technicianDetails.postValue(response.body())
            } else {
                Log.e("Get Technician Details Data", "Failed!")
            }
        }
    }

    //login Tech
    fun loginTechVM(username: String, password: String) =
        repository.loginTech(username, password)

    val _rateupdate: MutableLiveData<TechnicianDataUpdate> by lazy {
        MutableLiveData<TechnicianDataUpdate>()
    }

    val rateupdate: LiveData<TechnicianDataUpdate> get() = _rateupdate

    fun updateRateVM(t:TechnicianRateField) = viewModelScope.launch {
        Log.d("update rate","ini func e")
        try {
            repository.updateRateData(t).let { response ->
                if (response.isSuccessful) {
                    _rateupdate.postValue(
                        response.body() as
                                TechnicianDataUpdate
                    )
                } else {
                    Log.e("Update Rate", "Failed")
                }
            }
        }catch (e:Exception){
            Log.e("update rate eror", e.toString())
        }
    }
}
