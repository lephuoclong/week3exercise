package com.example.secondexercise.features.security

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondexercise.R
import android.content.Intent
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.secondexercise.features.profile.Profile


class Register : AppCompatActivity() {
    private var editTextFullname :EditText?=null
    private var editTextEmail :EditText?=null
    private var editTextPassword :EditText?=null
    private var imageViewVisible:ImageView?=null
    private var btnSignUp:Button?=null
    private var btnComeBackWelcome:Button?=null
    private var containerLayout:ConstraintLayout?=null
    private var showPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_register)

        initializeWidget()

        imageViewVisible?.setOnClickListener {
            onClickShowPass()
        }

        btnSignUp?.setOnClickListener {
            goToVerifyActivity()
        }

        btnComeBackWelcome?.setOnClickListener {
            finishActivity()
        }

        containerLayout?.setOnTouchListener { v, event ->
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            true
        }
    }

    private fun finishActivity() {
        var intent = Intent(this@Register, Login::class.java)
        this.finish();
        startActivity(intent);
    }

    private fun goToVerifyActivity(){
        val fullName = editTextFullname?.text.toString().trim() == "exitsUser"
        val email = editTextEmail?.text.toString().trim() == "example@gmail.com"
        val password = editTextPassword?.text.toString().trim() == "123123"

        if (fullName){
            Toast.makeText(this@Register, "Username is exits!", Toast.LENGTH_SHORT).show()
        }

        if (email) {
            Toast.makeText(this@Register, "Email is exits!", Toast.LENGTH_SHORT).show()
        }

        if (password){
            Toast.makeText(this@Register, "You need an other strong password!", Toast.LENGTH_SHORT).show()
        }

        if( !fullName && !email && !password){
            Toast.makeText(this@Register, "Sign up success!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@Register, Profile::class.java)
            startActivity(intent)

        }


    }
    private fun onClickShowPass() {
        if(showPass){
            showPass=false
            editTextPassword?.transformationMethod=PasswordTransformationMethod.getInstance()
            imageViewVisible?.setImageResource(R.drawable.ic_visibility)
        }else{
            showPass=true
            editTextPassword?.transformationMethod=HideReturnsTransformationMethod.getInstance()
            imageViewVisible?.setImageResource(R.drawable.ic_visibility_off)
        }
    }
    private fun initializeWidget(){
        editTextFullname = findViewById(R.id.editTextFullnameSignup)
        editTextEmail = findViewById(R.id.editTextEmailSignup)
        editTextPassword = findViewById(R.id.editTextPasswordSignUp)
        imageViewVisible = findViewById(R.id.imageViewShowHidePassword)
        btnSignUp = findViewById(R.id.buttonSignUp)
        btnComeBackWelcome = findViewById(R.id.btnComeBackWelcome)
        containerLayout = findViewById(R.id.containerLayout)
    }
}


