package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.Customer
import com.uc.alp_vp_acleaning.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel

class CustomerViewModel @Inject constructor(private val repository:CustomerRepository )
    : ViewModel(){

        //Get Customer
        private val _customer : MutableLiveData<Customer> by lazy{
            MutableLiveData<Customer>
        }
        val customer: LiveData<Customer> get() = _customer

    fun getCustomerData() = viewModelScope.lauch{
        repository.getCustomerResult().let{
            if(response.isSuccessful){
                _customer.postValue(response.body())
            }else{
                Log.e("Get Customer Data", response.toString())
            }
        }
    }
        //

}