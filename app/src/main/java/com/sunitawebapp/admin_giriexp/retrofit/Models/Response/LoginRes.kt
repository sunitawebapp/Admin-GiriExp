package com.sunitawebapp.admin_giriexp.retrofit.Models.Response

data class LoginRes(
    val email: String,
    val parent_id: Int,
    val password: String,
    val registrationDate: String,
    val status: Int,
    val tblmastusertype_id: Int,
    val tblsysuserlogin_id: Int,
    val username: String
)