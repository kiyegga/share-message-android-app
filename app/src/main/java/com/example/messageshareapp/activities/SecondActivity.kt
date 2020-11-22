package com.example.messageshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.messageshareapp.R
import com.example.messageshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //safe call for null ?
        // safe call for null with ?.let {}

        val bundle: Bundle? = intent.extras
             val msg = bundle?.getString("user_message")

             //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
             showToast(msg!!)

             txvUserMessage.text = msg

    }
}