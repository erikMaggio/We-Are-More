package com.example.wearemore.modal.repository

import com.example.wearemore.modal.dataSource.DataSourceLogin
import com.example.wearemore.modal.response.VerifyUser
import com.melvin.ongandroid.model.repository.ResourceBase
import javax.inject.Inject

class LoginRepository @Inject constructor( val datasource: DataSourceLogin) {

    suspend fun postLogin(email:String, password:String): ResourceBase<VerifyUser> {
        return datasource.login(email,password)
    }
}