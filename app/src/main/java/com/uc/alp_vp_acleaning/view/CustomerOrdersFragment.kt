package com.uc.alp_vp_acleaning.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.adapter.OrderAdapter
import com.uc.alp_vp_acleaning.adapter.TechnicianAdapter
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerHomeBinding
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerOrdersBinding
import com.uc.alp_vp_acleaning.model.Kecamatan
import com.uc.alp_vp_acleaning.viewmodel.KecamatanViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerOrdersFragment : Fragment() {

    private lateinit var binding : FragmentCustomerOrdersBinding
    private lateinit var viewModel: KecamatanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentCustomerHomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(this).get(TechnicianViewModel::class.java)
////        viewModelTech = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(
////            Application()
////        )).get(TechnicianViewModel::class.java)
//        viewModel.getTechnicianData()
//
//        viewModel.technician.observe(viewLifecycleOwner, Observer{ response->
////            Log.e("Customer order", response.toString())
//            binding.rvOrders.layoutManager = LinearLayoutManager(context)
//            adapterTechnician = OrderAdapter(response, kecamatan)
//            binding.rvAllTech.adapter = adapterTechnician
//        })
    }
}