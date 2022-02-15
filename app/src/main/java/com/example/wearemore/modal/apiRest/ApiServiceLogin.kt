package com.example.wearemore.modal.apiRest

import com.example.wearemore.modal.response.VerifyUser
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServiceLogin {
    @POST("api/login")

    suspend fun PostUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<VerifyUser>
}