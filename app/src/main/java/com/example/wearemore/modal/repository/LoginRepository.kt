package com.example.wearemore.modal.repository

import com.example.wearemore.modal.dataSource.DataSourceLogin
import javax.inject.Inject

class LoginRepository @Inject constructor(val dataSourceLogin:DataSourceLogin){

    suspend fun postLogin(email:String,password:String){
        dataSourceLogin.apiServiceLogin.PostUser(email,password)
    }
}