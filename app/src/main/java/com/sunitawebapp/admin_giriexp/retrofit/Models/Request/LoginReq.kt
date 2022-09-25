package com.sunitawebapp.admin_giriexp.retrofit.Models.Request

data class LoginReq(
    val password: String,
    val userName: String,
    val userTypeID: Int
)
