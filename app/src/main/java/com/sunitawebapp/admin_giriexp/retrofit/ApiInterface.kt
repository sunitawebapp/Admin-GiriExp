package com.sunitawebapp.admin_giriexp.retrofit

import com.sunitawebapp.admin_giriexp.retrofit.models.Request.LoginReq
import com.sunitawebapp.admin_giriexp.retrofit.models.Response.AppVersionAvailRes
import com.sunitawebapp.admin_giriexp.retrofit.models.Response.LoginRes
import com.sunitawebapp.admin_giriexp.retrofit.models.Response.UserCountRes

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
}
