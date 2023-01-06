package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityOrderDetailBinding
import com.uc.alp_vp_acleaning.databinding.ActivityTechnicianDetailBinding
import com.uc.alp_vp_acleaning.model.OrderItemField
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginTechId
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
//        Toast.makeText(this, "o_id: $o_id", Toast.LENGTH_SHORT).show()
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

                if(detailStatus.text == "Pending"){
                    imageView7.setImageResource(R.drawable.historical)
                }
                if(detailStatus.text == "On-going"){
                    imageView7.setImageResource(R.drawable.reboot)
                }
                if(detailStatus.text == "Completed"){
                    imageView7.setImageResource(R.drawable.checkmark)
                }

                if(detailStatus.text != "Pending"){
                    btnAcc.isVisible = false
                }
                btnAcc.setOnClickListener{
                    var statusNew = "On-going"
                    var orderItemField = OrderItemField(o_id.toString(),statusNew)
                    viewModel.updateOrder(orderItemField)

                    val intent = Intent(this@OrderDetailActivity, MainActivity::class.java)
                    intent.putExtra("role", 1)
                    intent.putExtra("loginTechId", loginTechId)
                    startActivity(intent)
                }
            }

        })
    }
}