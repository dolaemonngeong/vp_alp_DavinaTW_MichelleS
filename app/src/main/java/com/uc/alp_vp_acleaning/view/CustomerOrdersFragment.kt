package com.uc.alp_vp_acleaning.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.adapter.OrderAdapter
import com.uc.alp_vp_acleaning.adapter.TechnicianAdapter
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerOrdersBinding
import com.uc.alp_vp_acleaning.model.Kecamatan
import com.uc.alp_vp_acleaning.model.Order
import com.uc.alp_vp_acleaning.model.Technician
import com.uc.alp_vp_acleaning.retrofit.FilterListener
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginCustId
import com.uc.alp_vp_acleaning.viewmodel.OrderViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerOrdersFragment : Fragment() {

    private lateinit var binding: FragmentCustomerOrdersBinding
    private lateinit var viewModelOrder: OrderViewModel
    private lateinit var adapterOrder: OrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        loginCustId
        binding = FragmentCustomerOrdersBinding.inflate(layoutInflater)
        var status = ""
        binding.pendingRb.setOnClickListener {
            status="pending"
            Toast.makeText(context, "ini pending", Toast.LENGTH_SHORT).show()
            filter(status)
        }
        binding.ongoingRb.setOnClickListener {
            status = "on-going"
            Toast.makeText(context, "ini ongoing", Toast.LENGTH_SHORT).show()
            filter(status)
        }
        binding.completedRb.setOnClickListener {
            status = "completed"
            Toast.makeText(context, "ini completed", Toast.LENGTH_SHORT).show()
            filter(status)
        }

        return binding.root
    }
    
    fun filter(status: String){
        viewModelOrder = ViewModelProvider(this@CustomerOrdersFragment).get(OrderViewModel::class.java)

        viewModelOrder.getOrderCustomerStatusData(loginCustId, status)

        viewModelOrder.order.observe(viewLifecycleOwner, Observer { response ->
//            Log.e("Customer Order", response)
            if(response.isEmpty()){
                Toast.makeText(context, "order masih kosong", Toast.LENGTH_SHORT).show()
            }else{
                binding.rvOrders.layoutManager = LinearLayoutManager(context)
                adapterOrder = OrderAdapter(response)
                binding.rvOrders.adapter = adapterOrder
            }
        })   
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}