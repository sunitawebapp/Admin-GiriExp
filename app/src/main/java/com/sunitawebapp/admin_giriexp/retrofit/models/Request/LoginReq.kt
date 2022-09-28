package com.sunitawebapp.admin_giriexp.retrofit.models.Request

data class LoginReq(
    val password: String,
    val userName: String,
    val userTypeID: Int
)
