package com.sunitawebapp.admin_giriexp.retrofit

import com.sunitawebapp.admin_giriexp.retrofit.Models.Request.LoginReq
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("isUpdateAvailable")
    fun isUpdateAvailable(@Query("configCode") configCode : String,@Query("appVersion") appVersion : String)

    @POST("userLogin")
    fun isuserLogin(@Body loginReq : LoginReq)
}
