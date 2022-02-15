package com.example.wearemore.modal.dataSource

import com.example.wearemore.modal.apiRest.ApiServiceLogin
import javax.inject.Inject

class DataSourceLogin @Inject constructor(val apiServiceLogin: ApiServiceLogin){

    suspend fun PostUser(email:String,password:String){
        apiServiceLogin.PostUser(email,password)
    }
}