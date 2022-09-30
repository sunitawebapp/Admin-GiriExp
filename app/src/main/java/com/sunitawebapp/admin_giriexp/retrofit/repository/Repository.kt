package com.sunitawebapp.admin_giriexp.retrofit.repository

import com.sunitawebapp.admin_giriexp.BuildConfig
import com.sunitawebapp.admin_giriexp.retrofit.ApiClient
import com.sunitawebapp.admin_giriexp.retrofit.ApiInterface
import com.sunitawebapp.admin_giriexp.retrofit.models.Request.LoginReq
import com.sunitawebapp.admin_giriexp.utils.Constents

object Repository {
    suspend fun login(loginRequest: LoginReq) =
        ApiClient.createService(ApiInterface::class.java).isuserLogin(loginRequest)

        suspend fun versionAvailable() =
            ApiClient.createService(ApiInterface::class.java).isUpdateAvailable(Constents.configCode, BuildConfig.VERSION_NAME)

    suspend fun UserCount() =
        ApiClient.createService(ApiInterface::class.java).getUserCount()
    suspend fun ApprovalList(tblsysuserlogin_id : Int,tblmastusertype_id : Int) =
        ApiClient.createService(ApiInterface::class.java).getApprovalList(tblsysuserlogin_id,tblmastusertype_id)
}
