package com.uc.alp_vp_acleaning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uc.alp_vp_acleaning.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
    }
}