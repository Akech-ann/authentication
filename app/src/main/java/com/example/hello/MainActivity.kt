package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.hello.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root) //binding activity to one layout ie linking


        //make sure you cast before onclick listener.


    }

    override fun onResume() {
        super.onResume()

        binding.tvlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }
    }


    fun validateSignUp() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val pass = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "First name is required"
            error = true
        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (pass.isBlank()) {
            binding.tillPass.error = "Password is required"
            error = true
        }
        if (confirmPassword.isBlank()) {
           binding. tilConfirmPassword.error = "password confirmation is required"
            error = true
        }
        if (pass != confirmPassword) {
            binding.tilConfirmPassword.error = "pasword and confirmation do not match"
            error = true
        }
        if (!error) {
            Toast.makeText(this, "$firstName $lastName $email", Toast.LENGTH_LONG).show()

        }

    }
}