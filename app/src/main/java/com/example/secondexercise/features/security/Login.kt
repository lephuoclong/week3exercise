package com.example.secondexercise.features.security

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondexercise.R

import android.content.Intent
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.secondexercise.features.profile.Profile

class Login : AppCompatActivity() {
    private var btnGoBackWelcome:ImageButton?=null
    private var txtUsername:EditText?=null
    private var txtPassword:EditText?=null
    private var btnLogin:Button?=null
    private var containerLayout: ConstraintLayout?=null
    private var btnGotoSignUp:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        initializeWidget()

        btnGoBackWelcome?.setOnClickListener(){
            this.finish()
        }

        btnGotoSignUp?.setOnClickListener{
            var intent = Intent(this@Login, Register::class.java)
            this.finish()
            startActivity(intent)
        }

        btnLogin?.setOnClickListener(){
            handleLogin()
        }

        containerLayout?.setOnTouchListener { v, event ->
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            true
        }

    }

    private fun handleLogin() {
        var username = txtUsername?.text.toString().trim() == "ronaldo@gmail.com"
        var password = txtPassword?.text.toString().trim() == "123456"

        if(username && password) {
            Toast.makeText(this@Login, "Login Success!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@Login, Profile::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this@Login, "Username or password incorrect!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initializeWidget() {
        btnGoBackWelcome = findViewById(R.id.imgBtnComeback)
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnGotoSignUp = findViewById(R.id.btnGotoSignup)
        containerLayout = findViewById(R.id.containerLayout)
    }
}