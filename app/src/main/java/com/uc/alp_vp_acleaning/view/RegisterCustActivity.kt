package com.uc.alp_vp_acleaning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityLoginAsBinding
import com.uc.alp_vp_acleaning.databinding.ActivityRegisterCustBinding
import com.uc.alp_vp_acleaning.model.CustomerItem
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterCustActivity : AppCompatActivity() {
    private lateinit var  viewBind : ActivityRegisterCustBinding
    private lateinit var viewModelCust : CustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBind = ActivityRegisterCustBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()

        viewModelCust = ViewModelProvider(this).get(CustomerViewModel::class.java)

        viewBind.apply {
            buttonRegistercust.setOnClickListener{
                val customer = CustomerItem("",regEmailcust.text.toString(), regNamecust.text.toString(), regPasscust.text.toString(), regPhonecust.text.toString(), "active", regUnamecust.text.toString())
                viewModelCust.createCustomerVM(customer)
            }
        }
    }
}