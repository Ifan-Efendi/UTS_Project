package com.id.newsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val pass = intent.getStringExtra("password")
        val email = intent.getStringExtra("email")
        val edtEmail = findViewById<EditText>(R.id.username_edittext)
        val edtPassword = findViewById<EditText>(R.id.password_edittext)
        val btnLogin = findViewById<Button>(R.id.login_button)

        btnLogin.setOnClickListener {
            if (email == edtEmail.text.toString() && pass == edtPassword.text.toString()) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_LONG)
                    .show()
                Log.d("Login Activity", "Login: Login Berhasil", )
            }else{
                edtPassword.setText("")
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_LONG)
                    .show()
                Log.e("Login Activity", "Login: Username atau Password Salah", )
            }
        }
    }
}