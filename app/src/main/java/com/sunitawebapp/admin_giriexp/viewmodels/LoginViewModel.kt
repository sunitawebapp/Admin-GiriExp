package com.sunitawebapp.admin_giriexp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sunitawebapp.admin_giriexp.retrofit.Resource

import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(application: Application) : AndroidViewModel(application) {
 /*   var loginLiveData: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            loginReq(loginRequest)
        }
    }

    private suspend fun loginReq(loginRequest: LoginRequest) {
        loginLiveData.postValue(Resource.Loading())
        val loginRes = LoginRepository.login(loginRequest)
        loginLiveData.postValue(handleLoginRes(loginRes))
    }

    private fun handleLoginRes(loginRes: Response<LoginResponse>): Resource<LoginResponse> {
        if (loginRes.isSuccessful) {
            loginRes.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(loginRes.message())
    }*/
}