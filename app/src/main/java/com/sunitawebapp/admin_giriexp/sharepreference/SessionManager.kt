package com.sunitawebapp.admin_giriexp.sharepreference

import android.content.Context
import android.content.SharedPreferences

class SessionManager(  var context: Context) {
    var praference: SharedPreferences
    var editor: SharedPreferences.Editor


    init {

        praference = context.getSharedPreferences("SessionManager", 0)
        editor = praference.edit()
    }

    fun setusertypeid(usertypeid: Int) {
        editor.putInt("usertypeid", usertypeid)
        editor.apply()
    }

    fun getusertypeid(): Int {
        return praference.getInt("usertypeid", 0)
    }

    fun setuserloginid(userloginid: Int) {
        editor.putInt("userloginid", userloginid)
        editor.apply()
    }

    fun getuserloginid(): Int {
        return praference.getInt("userloginid", 0)
    }

}