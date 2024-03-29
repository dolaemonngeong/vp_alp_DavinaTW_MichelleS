package com.uc.alp_vp_acleaning.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.databinding.ActivityTechnicianDetailBinding
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechnicianDetailActivity : AppCompatActivity() {
    private lateinit var bind: ActivityTechnicianDetailBinding
    private lateinit var viewModel: TechnicianViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTechnicianDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        supportActionBar?.hide()

        val t_id = intent.getIntExtra("t_id", 0)
//        Toast.makeText(applicationContext, "t_id: $t_id", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProvider(this)[TechnicianViewModel::class.java]
        viewModel.getTechnicianDetails(t_id)
        viewModel.technicianDetails.observe(this, Observer { response ->
//            if (t_id <= response.size) {
                bind.displayNameTech.text = response.t_name
                bind.displayDistrictTech.apply {
                    text = response.Kecamatan.kecamatan_name
                }
                bind.displayRateTech.apply {
                    text = response.rate.toString()
                }
                bind.chatBtn.setOnClickListener {
                    val url =
                        "https://api.whatsapp.com/send?phone=" + response.phone + "&text=Halo%Perkenalkan%Nama%20Di%20Saya%20..."
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
                bind.orderBtn.setOnClickListener {
                    val keOrder = Intent(it.context, FormOrderActivity::class.java)
                    keOrder.putExtra("t_id", t_id)
                    it.context.startActivity(keOrder)
                }
//            }
        })
    }
}