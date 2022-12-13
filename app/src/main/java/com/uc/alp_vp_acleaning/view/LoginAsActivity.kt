package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uc.alp_vp_acleaning.databinding.ActivityLoginAsBinding

class LoginAsActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityLoginAsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityLoginAsBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()

        viewBind.apply {
            cardTech.setOnClickListener{
                val intent = Intent(it.context, LoginActivity::class.java)
                intent.getStringExtra("technician")
                it.context.startActivity(intent)
            }
            cardCust.setOnClickListener{
                val intent = Intent(it.context, LoginActivity::class.java)
                intent.getStringExtra("customer")
                it.context.startActivity(intent)
            }
        }
    }
}