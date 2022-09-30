package com.sunitawebapp.admin_giriexp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sunitawebapp.admin_giriexp.retrofit.Resource
import com.sunitawebapp.admin_giriexp.retrofit.models.response.ApproveListRes
import com.sunitawebapp.admin_giriexp.retrofit.repository.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ApprovalListViewModel  : ViewModel(){
    var ApprovalListLivedata : MutableLiveData<Resource<ApproveListRes>> = MutableLiveData()

    fun ApprovalList(tblsysuserlogin_id : Int,tblmastusertype_id : Int){
        GlobalScope.launch {
            apicallForApprovalList(tblsysuserlogin_id,tblmastusertype_id)
        }
    }

    suspend   fun apicallForApprovalList(tblsysuserlogin_id : Int,tblmastusertype_id : Int){
        ApprovalListLivedata.postValue(Resource.Loading())
        var res= Repository.ApprovalList(tblsysuserlogin_id,tblmastusertype_id)
        res.body()?.let {
            ApprovalListLivedata.postValue(Resource.Success(it))
        }

    }
}