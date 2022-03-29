package com.example.wearemore.modal.dataSource

import com.example.wearemore.modal.apiRest.ApiServiceLogin
import com.example.wearemore.modal.response.VerifyUser
import com.melvin.ongandroid.model.repository.BaseDataSource
import com.melvin.ongandroid.model.repository.ResourceBase
import javax.inject.Inject

class DataSourceLogin @Inject constructor(val apiServiceLogin: ApiServiceLogin) :
    BaseDataSource() {


    // aca se implemento el metodo de la clase abstracta BaseDataSource,
    // que pide pór parametro un metodo con Response
    suspend fun login(email: String, password: String): ResourceBase<VerifyUser> {
        return getResult { apiServiceLogin.PostUser(email, password) }
    }
}