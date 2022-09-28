package com.sunitawebapp.admin_giriexp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sunitawebapp.admin_giriexp.retrofit.models.Response.UserCountResItem
import com.sunitawebapp.admin_giriexp.retrofit.Resource
import com.sunitawebapp.admin_giriexp.retrofit.models.Response.UserCountRes
import com.sunitawebapp.admin_giriexp.retrofit.repository.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TotalUserCountViewModel: ViewModel() {
    var totalUserCountLivedata : MutableLiveData<Resource<UserCountRes>> = MutableLiveData()

    fun UserCount(){
        GlobalScope.launch {
            apicallForUserCount()
        }
    }

   suspend   fun apicallForUserCount(){
       totalUserCountLivedata.postValue(Resource.Loading())
        var res=Repository.UserCount()
       res.body()?.let {
           totalUserCountLivedata.postValue(Resource.Success(it))
       }

    }
}
