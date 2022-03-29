package com.example.wearemore.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wearemore.modal.repository.LoginRepository
import com.example.wearemore.modal.response.VerifyUser
import com.melvin.ongandroid.model.repository.ResourceBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {

    val liveDataLogin = MutableLiveData<ResourceBase<VerifyUser>>()

    fun authLogin(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = loginRepository.postLogin(email, password)
            if (call.isSuccessful())
                liveDataLogin.postValue(call)
        }
    }

    val liveStatus = MutableLiveData<Boolean>()

    fun validateStatus(email: String, password: String) {
        if (email.isNotEmpty()
            && password.isNotEmpty()
        ) {
            liveStatus.postValue(true)
        } else {
            liveStatus.postValue(false)
        }
    }

}