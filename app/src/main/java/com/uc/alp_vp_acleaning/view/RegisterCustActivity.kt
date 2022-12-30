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
            var fullname = regNamecust.text.toString().trim()
            var customername = regUnamecust.text.toString().trim()
            var email = regEmailcust.text.toString().trim()
            var phone_no = regPhonecust.text.toString().trim()
            var password = regPasscust.text.toString().trim()

            val customer = CustomerItem(
                "",
                email,
                fullname,
                password,
                phone_no,
                "active",
                customername
            )


            // fullname
            if (fullname.isEmpty()) {
                fullname. = "Please fill your fullname"
                isCompleted = false
            } else {
                fullname.error = ""
            }

            // customername
            if (customer.customername!!.isEmpty()) {
                customername_edit.error = "Please fill your customername"
                isCompleted = false
            } else {
                customername_edit.error = ""
            }

            //Phone no
            if (customer.phone_no!!.isEmpty()) {
                phoneno_edit.error = "Please fill your phone number"
                isCompleted = false
            } else {
                phoneno_edit.error = ""
            }

            //Email
            if (customer.email!!.isEmpty()) {
                email_edit.error = "Please fill your email"
                isCompleted = false
            } else {
                // Berguna untuk cek apakah input merupakan email
                if (!Patterns.EMAIL_ADDRESS.matcher(customer.email).matches()) {
                    email_edit.error = "Please fill your email correctly"
                    isCompleted = false
                } else {
                    email_edit.error = ""
                }
            }

            if (!customerconfirm.confirmpassword.equals(customer.password)) {
                confirmpassword_edit.error = "Please fill in the same as your password"
                isCompleted = false
            } else {
                confirmpassword_edit.error = ""
            }
//         Password
            if (customer.password!!.isEmpty()) {
                password_edit.error = "Please fill your password"
                confirmpassword_edit.error = "Please fill your password"
                isCompleted = false
            } else {

                if (customer.password!!.length < 8) {
                    password_edit.error = "Jumlah password min 8 karakter"
                    confirmpassword_edit.error = "Jumlah password min 8 karakter"
                    isCompleted = false
                } else if (!customer.password!!.matches(".*[a-z].*".toRegex())) {
                    password_edit.error = "Password tidak memiliki huruf kecil"
                    confirmpassword_edit.error = "Password tidak memiliki huruf kecil"
                    isCompleted = false
                } else if (!customer.password!!.matches(".*[A-Z].*".toRegex())) {
                    password_edit.error = "Password tidak memiliki huruf kapital"
                    confirmpassword_edit.error = "Password tidak memiliki huruf kapital"
                    isCompleted = false
                } else {
                    password_edit.error = ""
                    confirmpassword_edit.error = ""
                }
            }

            if (isCompleted) {
                viewModelCust = ViewModelProvider(this).get(CustomerViewModel::class.java)
                viewModelCust.createCustomerVM(customer)

                val intent = Intent(it.context, MainActivity::class.java)
                intent.putExtra("role", 0)
                it.context.startActivity(intent)

            }
        }
    }
}