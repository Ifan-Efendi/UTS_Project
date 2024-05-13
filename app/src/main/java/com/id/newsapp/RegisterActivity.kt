package com.id.newsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val edtEmail = findViewById<EditText>(R.id.username_edittext)
        val edtPassword = findViewById<EditText>(R.id.password_edittext)
        val edtRepassword = findViewById<EditText>(R.id.repassword_edittext)
        val btnRegis = findViewById<Button>(R.id.register_button)
        btnRegis.setOnClickListener {
            if (edtRepassword.text.toString() == edtPassword.text.toString()) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                intent.putExtra("email", edtEmail.text.toString())
                intent.putExtra("password", edtPassword.text.toString())
                startActivity(intent)
                finish()
                Toast.makeText(this, "Pendaftaran Berhasil", Toast.LENGTH_LONG)
                    .show()
                Log.d("Register Activity", "Register: Pendaftaran Berhasil", )
            }else{
                edtRepassword.setText("")
                Toast.makeText(this, "Password Tidak Sesuai", Toast.LENGTH_LONG)
                    .show()
                Log.e("Register Activity", "Register: Password Tidak Sesuai", )
            }
        }
    }
}