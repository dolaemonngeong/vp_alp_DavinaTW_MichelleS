package com.uc.alp_vp_acleaning.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alp_vp_acleaning.model.LoginRequest
import com.uc.alp_vp_acleaning.model.LoginResult
import com.uc.alp_vp_acleaning.repository.LoginRepository
import com.uc.alp_vp_acleaning.repository.TechnicianRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository):
    ViewModel() {

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

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
//                    _loginResult.value = LoginResult(success = message)
//                } else {
//                    _loginResult.value = LoginResult(error = R.string.login_failed)
//                }
//            } catch (e: Exception) {
//                _loginResult.value = LoginResult(error = R.string.login_failed)
//            }
        //}
    //}
}
