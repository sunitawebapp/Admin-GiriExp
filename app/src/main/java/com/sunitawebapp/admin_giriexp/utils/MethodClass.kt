package com.sunitawebapp.admin_giriexp.utils

import android.app.Activity
import com.sunitawebapp.admin_giriexp.R

class MethodClass {

    fun animation(activity : Activity){
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
