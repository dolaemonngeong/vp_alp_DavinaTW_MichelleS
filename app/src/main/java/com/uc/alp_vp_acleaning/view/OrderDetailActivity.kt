package com.uc.alp_vp_acleaning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityOrderDetailBinding
import com.uc.alp_vp_acleaning.databinding.ActivityTechnicianDetailBinding
import com.uc.alp_vp_acleaning.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderDetailActivity : AppCompatActivity() {
    private lateinit var bind: ActivityOrderDetailBinding
    private lateinit var viewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        supportActionBar?.hide()
        val o_id = intent.getIntExtra("o_id",0)
        Toast.makeText(this, "o_id: $o_id", Toast.LENGTH_SHORT).show()
        viewModel = ViewModelProvider(this)[OrderViewModel::class.java]
        viewModel.getOrderDetails(o_id)
        viewModel.orderDetails.observe(this, Observer{ response ->
            bind.apply {
                detailStatus.text = response.status
                orderId.text = response.o_id.toString()
                custName.text = response.name
                custPhone.text = response.phone
                custAddress.text = response.address
                custDate.text = response.date
                custTime.text = response.time

                if(response.note.Valid == true){
                    custNote.text = response.note.String
                }else{
                    custNote.text = ""
                }

                if(detailStatus.text != "Pending"){
                    btnAcc.isVisible = false
                }
                btnAcc.setOnClickListener{
                    viewModel
                }
            }

        })
    }
}