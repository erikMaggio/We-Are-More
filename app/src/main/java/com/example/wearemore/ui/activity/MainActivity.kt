package com.example.wearemore.ui.activity

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.example.wearemore.databinding.ActivityMainBinding
import com.example.wearemore.viewModel.LoginViewModel
import com.melvin.ongandroid.model.repository.ResourceBase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btLogin.setOnClickListener {
            loginViewModel.authLogin(
                binding.edEmail.text.toString(),
                binding.edPassword.text.toString()
            )
            Toast.makeText(this,"funciona",Toast.LENGTH_LONG).show()
        }


        loginViewModel.liveStatus.observe(this) {
            binding.btLogin.isEnabled = it
        }

        binding.btLogin.doAfterTextChanged {
            loginViewModel.validateStatus(
                it.toString(),
                binding.edPassword.text.toString()
            )
        }
        binding.btLogin.doAfterTextChanged {
            loginViewModel.validateStatus(
                binding.edEmail.text.toString(),
                it.toString()
            )
        }
    }


    fun alerDialogError(context: Context) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Falla Del Sistema")
        alertDialog.setMessage("Ha ocurrido un error obteniendo la información")
        alertDialog.setPositiveButton("Reintentar") { _, _ ->
        }
        alertDialog.setNegativeButton("Cancelar") { _, _ ->

        }
        alertDialog.show()
    }

    fun status(status: ResourceBase.Status) {

        when (status) {
            ResourceBase.Status.SUCCESS -> {

            }

            ResourceBase.Status.ERROR -> {

            }
            ResourceBase.Status.LOADING -> {
            }
        }
    }
}

