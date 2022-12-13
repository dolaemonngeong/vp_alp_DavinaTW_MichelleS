package com.uc.alp_vp_acleaning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityLoginAsBinding
import com.uc.alp_vp_acleaning.databinding.ActivityRegisterCustBinding

class RegisterCustActivity : AppCompatActivity() {
    private lateinit var  viewBind : ActivityRegisterCustBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBind = ActivityRegisterCustBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()

        viewBind.apply {
            buttonRegistercust.setOnClickListener{
                //
            }
        }
    }
}