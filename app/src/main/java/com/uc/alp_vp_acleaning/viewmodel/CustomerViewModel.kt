package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.CustomerData
import com.uc.alp_vp_acleaning.model.CustomerItem
import com.uc.alp_vp_acleaning.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class CustomerViewModel @Inject constructor(private val repository: CustomerRepository) :
    ViewModel() {

    //login Customer
    suspend fun loginCustomer(username: String, password: String) =
        repository.getCustomerResult(username, password)

    //Get Customer
    private val _customer: MutableLiveData<CustomerItem> by lazy {
        MutableLiveData<CustomerItem>()
    }
    val customer: LiveData<CustomerItem> get() = _customer

    fun getCustomerById(c_id:Int) = viewModelScope.launch {
        repository.getUserById(c_id).let{
            response ->
            if (response.isSuccessful){
                _user.postValue(response.body())
            }
            else{
                Log.e("Get Data", "Failed!")
            }
        }
    }

//    fun getCustomerData() = viewModelScope.launch {
//        repository.getCustomerResult().let {
//                response ->
//            if (response.isSuccessful){
//                _customer.postValue(response.body() as
//                        CustomerData)
//            } else{
//                Log.e("Get Data", "Failed!")
//            }
//        }
//    }

    //create customer
    fun createCustomerVM(customer: CustomerItem) = viewModelScope.launch {
        repository.createCustomerResult(customer).let { response ->
            if (response.isSuccessful) {
                _customer.postValue(
                    response.body() as
                            CustomerData
                )
            } else {
                Log.e("Create Data", "Failed!")
            }
        }
    }
//    fun createCustomerVM(customer: CustomerItem) = viewModelScope.launch {
//        repository.createCustomerResult(customer).enqueue(object : Callback<CustomerData>{
//            override fun onResponse(call: Call<CustomerData>, response: Response<CustomerData>) {
//                if(response.isSuccessful){
//                    val lastInsertedID = response.body()?.data?.last_inserted_id
//                }else{
//                    Log.e("Create Customer","Fail")
//                }
//            }
//
//            override fun onFailure(call: Call<CustomerData>, t: Throwable) {
//                Log.e("Create Customer", "Failure")
//            }
//        })
//    }

//    fun getCustomerData() = viewModelScope.launch {
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