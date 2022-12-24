package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.Customer
import com.uc.alp_vp_acleaning.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel

class CustomerViewModel @Inject constructor(private val repository: CustomerRepository) :
    ViewModel() {

    //Get Customer
    private val _customer: MutableLiveData<Customer> by lazy {
        MutableLiveData<Customer>()
    }
    val customer: LiveData<Customer> get() = _customer

    fun getCustomerData(apiKey: String, language: String, page: Int) = viewModelScope.launch {
        repository.getCustomerResult().let {
                response ->
            if (response.isSuccessful){
                _customer.postValue(response.body() as
                        Customer)
            } else{
                Log.e("Get Data", "Failed!")
            }
        }
    }

    //create customer
//    fun createCustomerVM() = viewModelScope.launch {
//        repository.createCustomerResult(c).let{
//
//        }
//    }

//    fun getCustomerData() = viewModelScope.lauch {
//        repository.getCustomerResult().let {
//            if (response.isSuccessful) {
//                _customer.postValue(response.body())
//            } else {
//                Log.e("Get Customer Data", response.toString())
//            }
//        }
//    }
    //

}