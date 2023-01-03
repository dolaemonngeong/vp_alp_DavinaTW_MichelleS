package com.uc.alp_vp_acleaning.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginCustId
import com.uc.alp_vp_acleaning.viewmodel.OrderViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerOrdersFragment : Fragment() {

    private lateinit var binding: FragmentCustomerOrdersBinding
    private lateinit var viewModel: OrderViewModel
    private lateinit var adapterOrder: Order
    private lateinit var adapterTechnician: Technician
    private lateinit var viewModelOrder: Order

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginCustId
        binding = FragmentCustomerOrdersBinding.inflate(inflater, container, false)
        
        viewModelOrder = ViewModelProvider(this).get(TechnicianViewModel::class.java)
        viewModelOrder.get()

        viewModelOrder.technician.observe(viewLifecycleOwner, Observer{ response->
            Log.e("Technician name", response.toString())
            binding.rvAllTech.layoutManager = LinearLayoutManager(context)
            val kecamatan = ArrayList<Kecamatan>()
            adapterTechnician = TechnicianAdapter(response, kecamatan)
            binding.rvAllTech.adapter = adapterTechnician
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        

    }
}