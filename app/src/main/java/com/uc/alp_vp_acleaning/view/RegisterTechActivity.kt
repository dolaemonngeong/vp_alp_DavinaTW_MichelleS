package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityRegisterCustBinding
import com.uc.alp_vp_acleaning.databinding.ActivityRegisterTechBinding
import com.uc.alp_vp_acleaning.model.TechnicianItem1
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterTechActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityRegisterTechBinding
    private lateinit var viewModelTech: TechnicianViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityRegisterTechBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()

        viewBind.apply {
            buttonRegistertech.setOnClickListener {
                cek()
            }
        }
    }
    
    private fun cek(){
        var isCompleted: Boolean = true

//        viewBind.apply {
//            var name = regNametech.text.toString().trim()
//            var username = regUnametech.text.toString().trim()
//            var email = regEmailtech.text.toString().trim()
//            var phone_no = regPhonetech.text.toString().trim()
//            var password = regPasstech.text.toString().trim()
//
//            val technician = TechnicianItem1(
//                email,
//                1,
//                password,
//                phone_no,
//                "0",
//                "active",
//                "",
//                name,
//                username
//            )
//
//
//            // fullname
//            if (technician.t_name!!.isEmpty()) {
//                regNametech.error = "Please fill your fullname"
//                isCompleted = false
//            } else {
//                regNametech.error = ""
//            }
//
//            // username
//            if (technician.username!!.isEmpty()) {
//                regUnametech.error = "Please fill your username"
//                isCompleted = false
//            } else {
//                regUnametech.error = ""
//            }
//
//            //Phone no
//            if (technician.phone!!.isEmpty()) {
//                regPhonetech.error = "Please fill your phone number"
//                isCompleted = false
//            } else {
//                regPhonetech.error = ""
//            }
//
//            //Email
//            if (technician.email!!.isEmpty()) {
//                regEmailtech.error = "Please fill your email"
//                isCompleted = false
//            } else {
//                // Berguna untuk cek apakah input merupakan email
//                if (!Patterns.EMAIL_ADDRESS.matcher(technician.email).matches()) {
//                    regEmailtech.error = "Please fill your email correctly"
//                    isCompleted = false
//                } else {
//                    regEmailtech.error = ""
//                }
//            }
//
////         Password
//            if (technician.password!!.isEmpty()) {
//                regPasstech.error = "Please fill your password"
//                isCompleted = false
//            } else {
//
//                if (technician.password!!.length < 8) {
//                    regPasstech.error = "Jumlah password min 8 character"
//                    isCompleted = false
//                } else if (!technician.password!!.matches(".*[a-z].*".toRegex())) {
//                    regPasstech.error = "Password tidak memiliki huruf kecil"
//                    isCompleted = false
//                } else if (!technician.password!!.matches(".*[A-Z].*".toRegex())) {
//                    regPasstech.error = "Password tidak memiliki huruf kapital"
//                    isCompleted = false
//                } else {
//                    regPasstech.error = ""
//                }
//            }
//
//            if (isCompleted) {
//                viewModelTech = ViewModelProvider(this@RegisterTechActivity).get(TechnicianViewModel::class.java)
//                viewModelTech.createTechnicianVM(technician)
//
//                done()
//            }
//        }
    }

    private fun done(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("role", 1)
        startActivity(intent)
    }
}