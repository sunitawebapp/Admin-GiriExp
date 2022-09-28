package com.sunitawebapp.admin_giriexp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sunitawebapp.admin_giriexp.retrofit.models.Response.AppVersionAvailRes
import com.sunitawebapp.admin_giriexp.retrofit.Resource
import com.sunitawebapp.admin_giriexp.retrofit.repository.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppVersionAvailableViewmodel : ViewModel(){
    var appVersionAvailLivedata: MutableLiveData<Resource<AppVersionAvailRes>> =  MutableLiveData()
    fun isUpdateAvailable(){
        GlobalScope.launch {
            apicallforUpdateAvailable()
        }
    }

   suspend fun apicallforUpdateAvailable(){
       appVersionAvailLivedata.postValue(Resource.Loading())
        var res=Repository.versionAvailable()
       var resbody=res.body()
       resbody?.let {
           appVersionAvailLivedata.postValue(Resource.Success(resbody))
       }

    }
}
