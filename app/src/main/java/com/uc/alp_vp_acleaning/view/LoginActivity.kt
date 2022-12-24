package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.uc.alp_vp_acleaning.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()

//        if(intent.getStringExtra("technician")){
//
//        }
//        Toast.makeText(applicationContext, "MovieID: $movieid", Toast.LENGTH_SHORT).show()

        val tech = intent.getIntExtra("role", 1)

        if (tech == 1) {
            viewBind.apply {
                toRegister.setOnClickListener {
                    val intent = Intent(it.context, RegisterTechActivity::class.java)
                    it.context.startActivity(intent)
                }
                buttonLogin.setOnClickListener {
                    val intent = Intent(it.context, MainActivity::class.java)
                    intent.putExtra("role", 1)
                    it.context.startActivity(intent)
                }
            }
        } else {
            viewBind.apply {
                maintitleLogin.text = "Log In as Customer"
                toRegister.setOnClickListener {
                    val intent = Intent(it.context, RegisterCustActivity::class.java)
                    it.context.startActivity(intent)
                }
                buttonLogin.setOnClickListener {
                    val intent = Intent(it.context, MainActivity::class.java)
                    intent.putExtra("role", 0)
                    it.context.startActivity(intent)
                }
            }
        }
    }

}
