package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.uc.alp_vp_acleaning.databinding.ActivityLoginBinding
import com.uc.alp_vp_acleaning.model.LoginRequestCust
import com.uc.alp_vp_acleaning.model.LoginRequestTech
import com.uc.alp_vp_acleaning.model.LoginResponse
import com.uc.alp_vp_acleaning.repository.LoginRepository
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import com.uc.alp_vp_acleaning.viewmodel.LoginViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityLoginBinding
    private lateinit var viewModel: CustomerViewModel
    private lateinit var viewModelTech: TechnicianViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        supportActionBar?.hide()


        val tech = intent.getIntExtra("role", 1)

        if (tech == 1) {
            viewBind.apply {
                toRegister.setOnClickListener {
                    val intent = Intent(it.context, RegisterTechActivity::class.java)
                    it.context.startActivity(intent)
                }
                buttonLogin.setOnClickListener {
                    cekTech()
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
//                    val username = loginUsername.text.toString().trim()
//                    val password = loginPass.text.toString().trim()
//
//                    val login = LoginRequest(username, password)
                    cekCust()

                }
            }
        }
    }

    private fun cekCust() {
        val username = viewBind.loginUsername.text.toString().trim()
        val password = viewBind.loginPass.text.toString().trim()

//            val loginrequest = LoginRequestCust(username, password)
        var isCompleted: Boolean = true

        // username
        if (username.isEmpty()) {
            viewBind.loginUsername.error = "Please fill your username"
            isCompleted = false
        } else {
            viewBind.loginUsername.error = ""
        }

        // password
        if (password.isEmpty()) {
            viewBind.loginPass.error = "Please fill your password"
            isCompleted = false
        } else {
            viewBind.loginPass.error = ""
        }

        if (isCompleted) {
//                viewModel = ViewModelProvider(this@LoginActivity).get(LoginViewModel::class.java)
            //viewModel.loginResponse.observe(this@LoginActivity, Observer { response ->
//                    Log.e("login", response.toString())
            //loginCustVM(loginrequest)
            //}
//                private val repository: LoginRepository

//                doneCust()
            viewModel = ViewModelProvider(this@LoginActivity).get(CustomerViewModel::class.java)
            viewModel.loginCustomerVM(username, password)
                .enqueue(object : retrofit2.Callback<LoginRequestCust> {
                    override fun onResponse(
                        call: retrofit2.Call<LoginRequestCust>,
                        response: retrofit2.Response<LoginRequestCust>
                    ) {
                        if (response.isSuccessful) {
                            val myIntent = Intent(this@LoginActivity, MainActivity::class.java)

                            Toast.makeText(
                                this@LoginActivity,
                                response.body()?.c_id,
                                Toast.LENGTH_SHORT
                            ).show()

                            myIntent.putExtra("loginCustId", response.body()?.c_id?.toInt())
                            myIntent.putExtra("role", 0)
                            startActivity(myIntent)
                            Toast.makeText(
                                this@LoginActivity,
                                "Login Berhasil",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            finish()
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "Login Gagal",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }

                    override fun onFailure(call: retrofit2.Call<LoginRequestCust>, t: Throwable) {
                        Log.d("TAG", "onFailure: ${t.message}")
                    }
                })
        }
    }

    private fun cekTech() {
        val username = viewBind.loginUsername.text.toString().trim()
        val password = viewBind.loginPass.text.toString().trim()

//            val loginrequest = LoginRequestCust(username, password)
        var isCompleted: Boolean = true

        // username
        if (username.isEmpty()) {
            viewBind.loginUsername.error = "Please fill your username"
            isCompleted = false
        } else {
            viewBind.loginUsername.error = ""
        }

        // password
        if (password.isEmpty()) {
            viewBind.loginPass.error = "Please fill your password"
            isCompleted = false
        } else {
            viewBind.loginPass.error = ""
        }

        if (isCompleted) {
            viewModelTech = ViewModelProvider(this@LoginActivity).get(TechnicianViewModel::class.java)
            viewModelTech.loginTechVM(username, password)
                .enqueue(object : retrofit2.Callback<LoginRequestTech> {
                    override fun onResponse(
                        call: retrofit2.Call<LoginRequestTech>,
                        response: retrofit2.Response<LoginRequestTech>
                    ) {
                        if (response.isSuccessful) {
                            val myIntent = Intent(this@LoginActivity, MainActivity::class.java)

                            Toast.makeText(
                                this@LoginActivity,
                                response.body()?.t_id,
                                Toast.LENGTH_SHORT
                            ).show()

                            myIntent.putExtra("loginTechId", response.body()?.t_id?.toInt())
                            myIntent.putExtra("role", 1)
                            startActivity(myIntent)
                            Toast.makeText(
                                this@LoginActivity,
                                "Login Berhasil",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            finish()
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "Login Gagal",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }

                    override fun onFailure(call: retrofit2.Call<LoginRequestTech>, t: Throwable) {
                        Log.d("TAG", "onFailure: ${t.message}")
                    }
                })
        }
    }
}
