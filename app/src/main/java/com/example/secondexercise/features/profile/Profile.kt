package com.example.secondexercise.features.profile

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.secondexercise.R
import com.example.secondexercise.features.security.Login

class Profile : AppCompatActivity() {

    private lateinit var btnTextFullname:Button
    private lateinit var btnTextEmail:Button
    private lateinit var btnTextPhone: Button
    private lateinit var txtFullname:TextView
    private lateinit var btnBack:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_profile)

        initializeWidget()

        btnTextFullname.setOnClickListener {
            showDialogProfile()
        }
        btnTextEmail.setOnClickListener {
            showDialogProfile()
        }
        btnTextPhone.setOnClickListener {
            showDialogProfile()
        }
        btnBack.setOnClickListener {
            back()
        }
    }

    private fun back() {
        val intent = Intent(this@Profile, Login::class.java)
        this.finish()
        startActivity(intent)
    }

    private fun showDialogProfile() {
        val dialog = Dialog(this@Profile).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dialog_profile)
            val edtFullname = findViewById<EditText>(R.id.editTextFullnameProfileDialog)
            val edtEmail= findViewById<EditText>(R.id.editTextEmailProfileDialog)
            val edtPhone = findViewById<EditText>(R.id.editTextPhoneNumberProfileDialog)
            val buttonOk = findViewById<Button>(R.id.buttonOkProfileDialog)

            edtFullname.setText(btnTextFullname.text.toString().trim())
            edtEmail.setText(btnTextEmail.text.toString().trim())
            edtPhone.setText(btnTextPhone.text.toString().trim())

            buttonOk.setOnClickListener {
                val fullname=edtFullname.text.toString().trim()
                val email = edtEmail.text.toString().trim()
                val phone = edtPhone.text.toString().trim()
                if(fullname.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()){
                    btnTextFullname.text=fullname
                    btnTextEmail.text=email
                    btnTextPhone.text=phone
                    txtFullname.text = fullname
                }
                cancel()
            }
        }
        dialog.show()
    }

    private fun initializeWidget() {
        btnTextFullname = findViewById(R.id.btnFullnameProfile)
        btnTextEmail = findViewById(R.id.btnEmailProfile)
        btnTextPhone = findViewById(R.id.btnPhoneNumberProfile)
        txtFullname = findViewById(R.id.textViewFullnameProfile)
        btnBack = findViewById(R.id.cardViewBack)
    }
}