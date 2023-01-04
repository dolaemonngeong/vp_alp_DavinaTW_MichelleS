package com.uc.alp_vp_acleaning.view

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.databinding.ActivityFormOrderBinding
import com.uc.alp_vp_acleaning.databinding.ActivityTechnicianDetailBinding
import com.uc.alp_vp_acleaning.model.CustomerItem
import com.uc.alp_vp_acleaning.model.OrderItem
import com.uc.alp_vp_acleaning.model.OrderItemCreate
import com.uc.alp_vp_acleaning.view.MainActivity.Companion.loginCustId
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import com.uc.alp_vp_acleaning.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class FormOrderActivity : AppCompatActivity() {

    private lateinit var viewModel: OrderViewModel
    private lateinit var binding: ActivityFormOrderBinding
    private lateinit var order: OrderItemCreate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        binding.datepicker.setOnClickListener {
            val dpd = DatePickerDialog(
                this@FormOrderActivity,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    binding.datepicker.setText("" + mYear + "-" + (mMonth+1) + "-" + mDay)

                },
                year,
                month,
                day
            )
            dpd.show()
        }

        binding.timepicker.setOnClickListener{
            val tpd = TimePickerDialog(
                this@FormOrderActivity,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    binding.timepicker.setText("" +hourOfDay + ":"+ minute +":00")
                },
                hour, minute, false
            )
            tpd.show()
        }

        binding.btnOrder.setOnClickListener {
            cekOrder()
        }
    }

    private fun cekOrder(){
        var isCompleted: Boolean = true

        binding.apply {
            var name = inputName.editText?.text.toString().trim()
            var address = inputAddress.editText?.text.toString().trim()
            var phone = inputPhone.editText?.text.toString().trim()
            var date = inputDate.editText?.text.toString().trim()
            var time = inputTime.editText?.text.toString().trim()
            var note = inputNote.editText?.text.toString().trim()

            order = OrderItemCreate(
                "",
                name,
                address,
                phone,
                time,
                date,
                note,
                intent.getIntExtra("t_id", 0),
                loginCustId,
                "pending",
            )

            //Time
            if (order.time!!.equals("Time")) {
                inputTime.error = "Please choose the Time"
                isCompleted = false
            } else {
                val timeNow = System.currentTimeMillis()
                val timeF = SimpleDateFormat("HH:mm::ss")
                timeF.format(timeNow)
                order = OrderItemCreate("", name, address, phone, time, date, note, intent.getIntExtra("t_id", 0), loginCustId, "pending",)
                inputTime.error = ""
                Log.e("o","tes")
            }

            if(order.date!!.equals("Date")){
                inputDate.error = "Please choose the Date"
                isCompleted = false
            } else {
                val datenow = System.currentTimeMillis()
                val date1 = Date(datenow)

                val format = SimpleDateFormat("yyyy-MM-dd")
                var dait: Date

                dait = format.parse(date)
                if (dait.before(date1)) {
                    inputDate.error = "Masukkan Tanggal yang benar"
                    isCompleted = false
                } else {
                    order = OrderItemCreate("", name, address, phone, time, date, note, intent.getIntExtra("t_id", 0), loginCustId, "pending",)
                    inputDate.error =""
                }
            }

            // fullname
            if (order.name!!.isEmpty()) {
                inputName.error = "Please fill your fullname"
                isCompleted = false
            } else {
                inputName.error = ""
            }

            // address
            if (order.address!!.isEmpty()) {
                inputAddress.error = "Please fill your username"
                isCompleted = false
            } else {
                inputAddress.error = ""
            }

            //Phone no
            if (order.phone!!.isEmpty()) {
                inputPhone.error = "Please fill your phone number"
                isCompleted = false
            } else {
                inputPhone.error = ""
            }


            if (isCompleted) {
                viewModel = ViewModelProvider(this@FormOrderActivity).get(OrderViewModel::class.java)
                viewModel.createOrderVM(order)

                Toast.makeText(this@FormOrderActivity, "Pesanan berhasil dibuat", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@FormOrderActivity, MainActivity::class.java)
                intent.putExtra("role", 0)
                intent.putExtra("loginCustId", loginCustId)
                startActivity(intent)
            }
        }
    }
}