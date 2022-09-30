package com.sunitawebapp.admin_giriexp.retrofit

import com.sunitawebapp.admin_giriexp.retrofit.models.Request.LoginReq
import com.sunitawebapp.admin_giriexp.retrofit.models.response.AppVersionAvailRes
import com.sunitawebapp.admin_giriexp.retrofit.models.response.ApproveListRes
import com.sunitawebapp.admin_giriexp.retrofit.models.response.LoginRes
import com.sunitawebapp.admin_giriexp.retrofit.models.response.UserCountRes

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("isUpdateAvailable")
   suspend fun isUpdateAvailable(@Query("configCode") configCode : String,@Query("appVersion") appVersion : String) : Response<AppVersionAvailRes>

    @POST("userLogin")
    suspend fun isuserLogin(@Body loginReq : LoginReq) : Response<LoginRes>

    @GET("getUserCount")
    suspend fun getUserCount() : Response<UserCountRes>

    @GET("getApprovalList")
    suspend fun getApprovalList(@Query("tblsysuserlogin_id") tblsysuserlogin_id : Int,
                                @Query("tblmastusertype_id") tblmastusertype_id : Int)

    : Response<ApproveListRes>
}
