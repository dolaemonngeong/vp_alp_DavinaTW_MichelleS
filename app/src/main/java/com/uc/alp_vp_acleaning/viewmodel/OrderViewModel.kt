package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.OrderItem
import com.uc.alp_vp_acleaning.model.TechnicianItem
import com.uc.alp_vp_acleaning.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val repository: OrderRepository):
    ViewModel(){

    //get Technician
    val _order:MutableLiveData<ArrayList<OrderItem>> by lazy{
        MutableLiveData<ArrayList<OrderItem>>()
    }

    val order: LiveData<ArrayList<OrderItem>> get() = _order

    fun getOrderData() = viewModelScope.launch {

        repository.getOrderResult().let {
                response ->
            //ikti movie
            if (response.isSuccessful){
                _order.postValue(response.body()?.data as ArrayList<OrderItem>?)
            } else{
                Log.e("Get Data", "Failed!")
            }

    //Get Order Details Data
    val _orderDetails: MutableLiveData<ArrayList<OrderItem>> by lazy {
        MutableLiveData<ArrayList<OrderItem>>()
    }

    val orderDetails: LiveData<ArrayList<OrderItem>> get() = _orderDetails

    fun getOrderDetails(t_id: Int) = viewModelScope.launch {
        repository.getOrderDetailsData(t_id).let {
                response ->
            if (response.isSuccessful){
                _orderDetails.postValue(response.body()?.data as ArrayList<OrderItem>?)
            } else{
                Log.e("Get Order Details Data", "Failed!")
            }
        }
    }

}