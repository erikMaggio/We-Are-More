package com.example.wearemore.modal.response

import com.google.gson.annotations.SerializedName

data class VerifyUser(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: Array<Data>,
    @SerializedName("message") val message: String,
    @SerializedName("error") val messageError: String
)

class Data {
}