package com.uc.alp_vp_acleaning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uc.alp_vp_acleaning.databinding.ActivityTechnicianDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormOrderActivity : AppCompatActivity() {

    private lateinit var bind: ActivityTechnicianDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTechnicianDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}