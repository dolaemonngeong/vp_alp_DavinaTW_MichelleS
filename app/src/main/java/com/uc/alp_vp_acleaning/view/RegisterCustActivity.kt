package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityLoginAsBinding
import com.uc.alp_vp_acleaning.databinding.ActivityRegisterCustBinding
import com.uc.alp_vp_acleaning.model.CustomerItem
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.widget.EditText
import android.text.TextUtils


@AndroidEntryPoint
class RegisterCustActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityRegisterCustBinding
    private lateinit var viewModelCust: CustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBind = ActivityRegisterCustBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()


        viewBind.apply {
            buttonRegistercust.setOnClickListener {
//                viewModelCust = ViewModelProvider(this).get(CustomerViewModel::class.java)
//                var fullname = regNamecust.text.toString().trim()
//                var customername = regUnamecust.text.toString().trim()
//                var email = regEmailcust.text.toString().trim()
//                var phone_no = regPhonecust.text.toString().trim()
//                var password = regPasscust.text.toString().trim()
//
//                val customer = CustomerItem(
//                    "",
//                    email,
//                    fullname,
//                    password,
//                    phone_no,
//                    "active",
//                    customername
//                )
//                viewModelCust.createCustomerVM(customer)
//
//                val intent = Intent(it.context, MainActivity::class.java)
//                intent.putExtra("role", 0)
//                it.context.startActivity(intent)

                cek()
            }
        }
    }

    private fun cek() {
        var isCompleted: Boolean = true

        viewBind.apply {
            var name = regNamecust.text.toString().trim()
            var username = regUnamecust.text.toString().trim()
            var email = regEmailcust.text.toString().trim()
            var phone_no = regPhonecust.text.toString().trim()
            var password = regPasscust.text.toString().trim()

            val customer = CustomerItem(
                "",
                email,
                name,
                password,
                phone_no,
                "active",
                username
            )


            // fullname
            if (customer.name!!.isEmpty()) {
                regNamecust.error = "Please fill your fullname"
                isCompleted = false
            } else {
                regNamecust.error = ""
            }

            // username
            if (customer.username!!.isEmpty()) {
                regUnamecust.error = "Please fill your username"
                isCompleted = false
            } else {
                regUnamecust.error = ""
            }

            //Phone no
            if (customer.phone!!.isEmpty()) {
                regPhonecust.error = "Please fill your phone number"
                isCompleted = false
            } else {
                regPhonecust.error = ""
            }

            //Email
            if (customer.email!!.isEmpty()) {
                regEmailcust.error = "Please fill your email"
                isCompleted = false
            } else {
                // Berguna untuk cek apakah input merupakan email
                if (!Patterns.EMAIL_ADDRESS.matcher(customer.email).matches()) {
                    regEmailcust.error = "Please fill your email correctly"
                    isCompleted = false
                } else {
                    regEmailcust.error = ""
                }
            }

//            if (!customerconfirm.confirmpassword.equals(customer.password)) {
//                confirmpassword_edit.error = "Please fill in the same as your password"
//                isCompleted = false
//            } else {
//                confirmpassword_edit.error = ""
//            }

//         Password
            if (customer.password!!.isEmpty()) {
                regPasscust.error = "Please fill your password"
                isCompleted = false
            } else {

                if (customer.password!!.length < 8) {
                    regPasscust.error = "Jumlah password min 8 character"
                    isCompleted = false
                } else if (!customer.password!!.matches(".*[a-z].*".toRegex())) {
                    regPasscust.error = "Password tidak memiliki huruf kecil"
                    isCompleted = false
                } else if (!customer.password!!.matches(".*[A-Z].*".toRegex())) {
                    regPasscust.error = "Password tidak memiliki huruf kapital"
                    isCompleted = false
                } else {
                    regPasscust.error = ""
                }
            }

            if (isCompleted) {
                viewModelCust = ViewModelProvider(this@RegisterCustActivity).get(CustomerViewModel::class.java)
                viewModelCust.createCustomerVM(customer)

                done()
            }
        }
    }

    private fun done(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("role", 0)
        startActivity(intent)
    }
}