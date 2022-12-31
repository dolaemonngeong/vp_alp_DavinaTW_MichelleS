package com.uc.alp_vp_acleaning.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.*
import com.uc.alp_vp_acleaning.repository.LoginRepository
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) :
    ViewModel() {

    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    val loginError = MutableLiveData<String>()

    //login cust
//    fun loginCustVM(loginRequest: LoginRequest) {
//        repository.loginCustomer(loginRequest).enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                // Set the login response data on the observable field
//                loginResponse.value = response.body()
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                // Set the error on the observable field
//                loginError.value = t.message
//            }
//        })
//    }
//}


//    fun loginCustVM(loginRequest: LoginRequest){
//        viewModelScope.launch {
////            val loginRequest = LoginRequest(username, password = password)
//            val loginDeferred = repository.loginCustomer(loginRequest)
//            try {
//                val loginResponse = loginDeferred
//                if (loginResponse.isSuccessful) {
//                    val message = loginResponse.body()?.message
//                    val token = loginResponse.body()?.token
//                    // save the token and user data in shared preferences or session
//                    //malah eror di parameter LoginResult
//                    _loginResponse.value = LoginResponse(message, token)
//                } else {
//                    _loginResponse.value = LoginResponse(loginResponse.message(), "")
//                }
//            } catch (e: Exception) {
//                _loginResponse.value = LoginResponse("", "")
//            }
//            }
//    }

//    fun loginCustVM(loginRequest: LoginRequest) = viewModelScope.launch {
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
//}

//    private val _loginResult = MutableLiveData<LoginResult>()
//    val loginResult: LiveData<LoginResponse> = _loginResult
//
//    fun login(username: String, password: String) {
//        viewModelScope.launch {
//            val loginRequest = LoginRequest(username = username, password = password)
//            val loginDeferred = repository.loginTechnician(loginRequest)
//            try {
//                val loginResponse = loginDeferred.await()
//                if (loginResponse.isSuccessful) {
//                    val message = loginResponse.body()?.message
//                    val token = loginResponse.body()?.token
//                    // save the token and user data in shared preferences or session
//                    //malah eror di parameter LoginResult
//                    _loginResult.value = LoginResult(login = message)
//                } else {
//                    _loginResult.value = LoginResult(error = R.string.login_failed)
//                }
//            } catch (e: Exception) {
//                _loginResult.value = LoginResult(error = R.string.login_failed)
//            }
//        }
//    }
}
