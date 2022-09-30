package com.sunitawebapp.admin_giriexp.retrofit.models.response

data class ApproveListResItem(
    val creation_date: String,
    val email: String,
    val fullName: String,
    val isMobileVerified: Boolean,
    val isNameVerified: Boolean,
    val isStationVerified: Boolean,
    val mobile: String,
    val parent_id: Int,
    val stationCode: Int,
    val stationName: String,
    val status: Int,
    val tblmastusertype_id: Int,
    val tblsysuserlogin_id: Int
)