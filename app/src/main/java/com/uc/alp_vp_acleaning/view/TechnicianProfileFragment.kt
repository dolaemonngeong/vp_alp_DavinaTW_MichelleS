package com.uc.alp_vp_acleaning.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerProfileBinding
import com.uc.alp_vp_acleaning.databinding.FragmentTechnicianProfileBinding
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginTechId
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechnicianProfileFragment : Fragment() {

    private lateinit var binding: FragmentTechnicianProfileBinding
    private lateinit var viewModel: TechnicianViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        Toast.makeText(context, "Login ID: $loginTechId", Toast.LENGTH_SHORT).show()
        binding = FragmentTechnicianProfileBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this@TechnicianProfileFragment).get(TechnicianViewModel::class.java)
        viewModel.getTechnicianDetails(loginTechId)


        viewModel.technicianDetails.observe(viewLifecycleOwner, Observer{
                response ->
//            Toast.makeText(context, "name" +response.t_name, Toast.LENGTH_SHORT).show()
            binding.nameTech.apply{
                text = response.t_name
            }
            binding.unameTech.apply{
                text = response.username
            }
            binding.phoneTech.apply{
                text = response.phone
            }
            binding.passTech.apply{
                text = response.email
            }
            binding.districtTech.apply{
                text = response.Kecamatan.kecamatan_name
            }

        })

        // Inflate the layout for this fragment
        return binding.root
    }
}