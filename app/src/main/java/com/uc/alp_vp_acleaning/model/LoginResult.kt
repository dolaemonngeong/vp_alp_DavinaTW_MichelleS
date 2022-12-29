package com.uc.alp_vp_acleaning.model

import androidx.annotation.StringRes

sealed class LoginResult {
    data class Success(val message: String) : LoginResult()
    data class Error(@StringRes val errorMessage: Int) : LoginResult()
}
