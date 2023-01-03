package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.CustomerData
import com.uc.alp_vp_acleaning.model.CustomerItem
import com.uc.alp_vp_acleaning.model.OrderItem
import com.uc.alp_vp_acleaning.model.TechnicianItem
import com.uc.alp_vp_acleaning.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class CustomerViewModel @Inject constructor(private val repository: CustomerRepository) :
    ViewModel() {
    //
    //login Customer
    fun loginCustomerVM(username: String, password: String) =
        repository.loginCust(username, password)

    val _customerLogin: MutableLiveData<CustomerItem> by lazy {
        MutableLiveData<CustomerItem>()
    }
    val customerLogin: LiveData<CustomerItem> get() = _customerLogin

    fun getCustomerById(c_id: Int) = viewModelScope.launch {
        repository.getCustById(c_id).let { response ->
            if (response.isSuccessful) {
                _customerLogin.postValue(response.body())
            } else {
                Log.e("Get Data", "Failed!")
            }
        }
    }

    //Get Customer buat create
    val _customer: MutableLiveData<CustomerData> by lazy {
        MutableLiveData<CustomerData>()
    }
    val customer: LiveData<CustomerData> get() = _customer

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

    //cust order
    val _order: MutableLiveData<ArrayList<OrderItem>> by lazy {
        MutableLiveData<ArrayList<OrderItem>>()
    }

    val order: LiveData<ArrayList<OrderItem>> get() = _order

    fun getTechnicianData(c_id, status) = viewModelScope.launch {

        repository.getOrderStatus().let { response ->
            //ikti movie
            if (response.isSuccessful) {
                _order.postValue(response.body()?.data as ArrayList<OrderItem>?)
            } else {
                Log.e("Get Data", "Failed!")
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