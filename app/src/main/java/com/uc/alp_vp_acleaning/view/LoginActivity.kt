package com.uc.alp_vp_acleaning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.uc.alp_vp_acleaning.databinding.ActivityLoginBinding
import com.uc.alp_vp_acleaning.model.LoginRequest
import com.uc.alp_vp_acleaning.model.LoginResponse
import com.uc.alp_vp_acleaning.repository.LoginRepository
import com.uc.alp_vp_acleaning.view.CustomerHomeFragment.Companion.loginCustId
import com.uc.alp_vp_acleaning.viewmodel.CustomerViewModel
import com.uc.alp_vp_acleaning.viewmodel.LoginViewModel
import com.uc.alp_vp_acleaning.viewmodel.TechnicianViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel


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
        binding.button_login.setOnClickListener {
            val username = binding.loginUsername.text.toString().trim()
            val password = binding.loginPass.text.toString().trim()

            val loginrequest = LoginRequest(username, password)
            var isCompleted: Boolean = true

            // username
            if (loginrequest.username.isEmpty()) {
                username.error = "Please fill your username"
                isCompleted = false
            } else {
                password.error = ""
            }

            // password
            if (loginrequest.password.isEmpty()) {
                loginPass.error = "Please fill your password"
                isCompleted = false
            } else {
                loginPass.error = ""
            }

            if (isCompleted) {
//                viewModel = ViewModelProvider(this@LoginActivity).get(LoginViewModel::class.java)
                //viewModel.loginResponse.observe(this@LoginActivity, Observer { response ->
//                    Log.e("login", response.toString())
                //loginCustVM(loginrequest)
                //}
//                private val repository: LoginRepository

//                doneCust()
                viewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)
                viewModel.LoginRequest(username, password)
                    .enqueue(object : retrofit2.Callback<LoginRequest> {
                        override fun onResponse(
                            call: retrofit2.Call<LoginRequest>,
                            response: retrofit2.Response<LoginRequest>
                        ) {
                            if (response.isSuccessful) {
                                val myIntent = Intent(this@LoginActivity, CustomerHomeFragment::class.java)
                                Toast.makeText(
                                    this@LoginActivity,
                                    response.body()?.id,
                                    Toast.LENGTH_SHORT
                                ).show()
                                myIntent.putExtra("loginCustId", response.body()?.toInt())
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

                        override fun onFailure(call: retrofit2.Call<button_login>, t: Throwable) {
                            Log.d("TAG", "onFailure: ${t.message}")
                        }
                    })
            }
        }


//    fun loginCustVM(loginRequest: LoginRequest) = launch {
//
//        private val _loginResponse = MutableLiveData<LoginResponse>()
//        val loginResponse: LiveData<LoginResponse> = _loginResponse
//        repository.loginCustomer(loginRequest).let { response ->
//            if (response.body()?.message === "Login successful" && response.isSuccessful) {
//                _loginResponse.postValue(
//                    response.body() as
//                            LoginResponse
//                )
//                Log.e("ini login cust","Beerhsl!")
//            } else {
//                Log.e("Login Customer", "Failed!")
//            }
//        }
//    }

//    private fun doneCust(){
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("role", 0)
//        startActivity(intent)
//        finish()
//    }
    }
}
