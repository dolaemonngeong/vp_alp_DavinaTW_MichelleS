package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.*
import com.uc.alp_vp_acleaning.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(private val repository: OrderRepository) :
    ViewModel() {
    //get Order
    val _ordercreate: MutableLiveData<OrderData> by lazy {
        MutableLiveData<OrderData>()
    }

    val ordercreate: LiveData<OrderData> get() = _ordercreate

    //create order
    fun createOrderVM(order: OrderItemCreate) = viewModelScope.launch {
        repository.createOrderResult(order).let { response ->
            if (response.isSuccessful) {
                _ordercreate.postValue(
                    response.body() as
                            OrderData
                )
            } else {
                Log.e("Create Data", "Failed!")
            }
        }
    }

    //get Order
    val _order: MutableLiveData<ArrayList<OrderItem>> by lazy {
        MutableLiveData<ArrayList<OrderItem>>()
    }

    val order: LiveData<ArrayList<OrderItem>> get() = _order

    fun getOrderTechStatusData(t_id: Int, status: String) = viewModelScope.launch {
        Log.d("order tech status vm", "msk")
        repository.getOrderTechStatus(t_id, status).let { response ->
            if (response.isSuccessful) {
                Log.d("tes", "msk response sukses")
                _order.postValue(response.body()?.data as ArrayList<OrderItem>?)
            } else {
                Log.d("Get Data", "Failed!")
            }


        }
    }

    fun getOrderCustomerStatusData(c_id: Int, status: String) = viewModelScope.launch {
        Log.d("order cust status vm", "msk")
        try {
            repository.getOrderCustomerStatus(c_id, status).let { response ->
                if (response.isSuccessful) {
                    Log.d("order cust status vm resp", "msk resp")

                    _order.postValue(response.body()?.data as ArrayList<OrderItem>?)

                } else {
                    Log.e("Get Data", "Failed!")
                }


            }
        } catch (e: Exception) {
            Log.e("order cust status vm resp", e.toString())
        }
    }


    //Get Order Details Data
    val _orderDetails: MutableLiveData<OrderItem> by lazy {
        MutableLiveData<OrderItem>()
    }

    val orderDetails: LiveData<OrderItem>
        get() = _orderDetails

    fun getOrderDetails(o_id: Int) = viewModelScope.launch {
        repository.getOrderDetailsData(o_id).let { response ->
            if (response.isSuccessful) {
                _orderDetails.postValue(response.body())
            } else {
                Log.e("Get Order Details Data", "Failed!")
            }
        }
    }

    val _orderupdate: MutableLiveData<OrderDataUpdate> by lazy {
        MutableLiveData<OrderDataUpdate>()
    }

    val orderupdate: LiveData<OrderDataUpdate> get() = _orderupdate


    fun updateOrder(o:OrderItemField) = viewModelScope.launch {
        repository.updateOrderResult(o).let { response->
            if(response.isSuccessful){
                _orderupdate.postValue(
                    response.body() as
                            OrderDataUpdate)
            }else{
                Log.e("Update Order","Failed")
            }
        }
    }

}

