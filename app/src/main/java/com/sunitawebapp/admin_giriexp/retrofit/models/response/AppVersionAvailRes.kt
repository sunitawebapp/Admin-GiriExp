package com.sunitawebapp.admin_giriexp.retrofit.models.response

data class AppVersionAvailRes(
    val dbVersion: String,
    val error: Boolean,
    val errorMsg: String,
    val isUpdateAvailable: Boolean
)
