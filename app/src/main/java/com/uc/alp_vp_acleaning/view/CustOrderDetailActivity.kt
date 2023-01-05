package com.uc.alp_vp_acleaning.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.uc.alp_vp_acleaning.R
import com.uc.alp_vp_acleaning.databinding.ActivityCustOrderDetailBinding
import com.uc.alp_vp_acleaning.databinding.ActivityOrderDetailBinding
import com.uc.alp_vp_acleaning.databinding.ActivityTechnicianDetailBinding
import com.uc.alp_vp_acleaning.model.OrderItemField
import com.uc.alp_vp_acleaning.model.TechnicianRateField
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginCustId
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginTechId
import com.uc.alp_vp_acleaning.viewmodel.OrderViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustOrderDetailActivity : AppCompatActivity() {
    private lateinit var bind: ActivityCustOrderDetailBinding
    private lateinit var viewModel: OrderViewModel
    private lateinit var viewModelTech: TechnicianViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCustOrderDetailBinding.inflate(layoutInflater)
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

                if(detailStatus.text == "Pending"){
                    imageView7.setImageResource(R.drawable.historical)
                }
                if(detailStatus.text == "On-going"){
                    imageView7.setImageResource(R.drawable.reboot)
                    btnAcc.isVisible = true
                    btnAcc.setOnClickListener{
                        var statusNew = "Completed"
                        var orderItemField = OrderItemField(o_id.toString(),statusNew)
                        viewModel.updateOrder(orderItemField)

                        val intent = Intent(this@CustOrderDetailActivity, MainActivity::class.java)
                        intent.putExtra("role", 0)
                        intent.putExtra("loginCustId", loginCustId)
                        startActivity(intent)
                    }
                }
                if(detailStatus.text == "Completed"){
                    imageView7.setImageResource(R.drawable.checkmark)
                    btnAcc.text = "RATE"
                    btnAcc.isVisible = true
                    btnAcc.setOnClickListener{
//                        var statusNew = "Completed"
//                        var orderItemField = OrderItemField(o_id.toString(),statusNew)
//                        viewModel.updateOrder(orderItemField)
                        val builder = AlertDialog.Builder(this@CustOrderDetailActivity)
                        val inflater = layoutInflater
                        val dialogLayout = inflater.inflate(R.layout.rate_dialog, null)
                        val rate1 = dialogLayout.findViewById<RadioButton>(R.id.rate1)
                        val rate2 = dialogLayout.findViewById<RadioButton>(R.id.rate2)
                        val rate3 = dialogLayout.findViewById<RadioButton>(R.id.rate3)
                        val rate4 = dialogLayout.findViewById<RadioButton>(R.id.rate4)
                        val rate5 = dialogLayout.findViewById<RadioButton>(R.id.rate5)
                        var ratenya= "0"
                        rate1.setOnClickListener {
                            ratenya = "1"
                            rate2.isChecked = false
                            rate3.isChecked = false
                        }
                        rate2.setOnClickListener {
                            ratenya = "2"
                        }
                        rate3.setOnClickListener {
                            ratenya = "3"
                        }
                        rate4.setOnClickListener {
                            ratenya = "4"
                        }
                        rate5.setOnClickListener {
                            ratenya = "5"
                        }
//                        Toast.makeText(this@CustOrderDetailActivity, "otw with", Toast.LENGTH_SHORT).show()

                        with(builder){
//                            Toast.makeText(this@CustOrderDetailActivity, "ini with", Toast.LENGTH_SHORT).show()
                            setTitle("Rate Technician")
                            setPositiveButton("OK"){
                                dialog, which ->
                                viewModelTech = ViewModelProvider(this@CustOrderDetailActivity).get(TechnicianViewModel::class.java)
                                var techRateField = TechnicianRateField(response.t_id, ratenya)
//                                Toast.makeText(this@CustOrderDetailActivity, "ini: $ratenya", Toast.LENGTH_SHORT).show()
                                viewModelTech.updateRateVM(techRateField)
                                Toast.makeText(this@CustOrderDetailActivity, "thank u for the rate", Toast.LENGTH_SHORT).show()
                                btnAcc.isVisible = false
                            }
                            setNegativeButton("CANCEL"){
                                    dialog, which ->
                                dialog.dismiss()
//                                Toast.makeText(this@CustOrderDetailActivity, "cancell", Toast.LENGTH_SHORT).show()
                            }
                            setView(dialogLayout)
                            show()
                        }

//                        val intent = Intent(this@CustOrderDetailActivity, MainActivity::class.java)
//                        intent.putExtra("role", 0)
//                        intent.putExtra("loginCustId", loginCustId)
//                        startActivity(intent)
                    }
                }
            }
        })
    }
}