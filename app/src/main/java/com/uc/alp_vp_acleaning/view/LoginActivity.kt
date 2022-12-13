package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.uc.alp_vp_acleaning.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBind : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()

//        if(intent.getStringExtra("technician")){
//
//        }
//        Toast.makeText(applicationContext, "MovieID: $movieid", Toast.LENGTH_SHORT).show()

        viewBind.apply {
            toRegister.setOnClickListener {
                val intent = Intent(it.context, RegisterTechActivity::class.java)
                it.context.startActivity(intent)
            }
        }
    }
}