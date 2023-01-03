package com.uc.alp_vp_acleaning.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.databinding.FragmentCustomerProfileBinding
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginCustId
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerProfileFragment : Fragment() {

    private lateinit var binding: FragmentCustomerProfileBinding
    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //loginCustId
        Toast.makeText(context, "Login ID: $loginCustId", Toast.LENGTH_SHORT).show()
        binding = FragmentCustomerProfileBinding.inflate(layoutInflater)
            viewModel = ViewModelProvider(this@CustomerProfileFragment).get(CustomerViewModel::class.java)
            viewModel.getCustomerById(loginCustId)


            viewModel.customerLogin.observe(viewLifecycleOwner, Observer{
                response ->
                Toast.makeText(context, "name" +response.name, Toast.LENGTH_SHORT).show()
                binding.nameCust.apply{
                    text = response.name
                }
                binding.unameCust.apply{
                    text = response.username
                }
                binding.phoneCust.apply{
                    text = response.phone
                }
                binding.emailCust.apply{
                    text = response.email
                }
                binding.passCust.apply{
                    text = response.password
                }

            })

        // Inflate the layout for this fragment
        return binding.root
    }


}