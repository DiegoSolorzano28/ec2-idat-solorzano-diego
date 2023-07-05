package com.example.ec2_solorzano_diego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.ec2_solorzano_diego.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews(){
        binding.tilEmail.editText?.addTextChangedListener{text ->
            binding.btnLogin.isEnabled=validateInputs(text.toString(), binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener {text ->
            binding.btnLogin.isEnabled=validateInputs(binding.tilEmail.editText?.text.toString(),text.toString())
        }
        binding.btnLogin.setOnClickListener{

            val email = binding.tilEmail.editText?.text.toString()
            val password = binding.tilPassword.editText?.text.toString()
            if (email == "ejemplo@idat.edu.pe" && password == "123456"){
                Toast.makeText(this,"Bienvenido", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(email: String, password: String): Boolean{
        val isEmailOk= email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordOk= password.length >= 6
        return isPasswordOk && isEmailOk
    }
}