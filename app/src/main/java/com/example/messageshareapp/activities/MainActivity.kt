package com.example.messageshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.messageshareapp.R
import com.example.messageshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
           // Log.i("MainActivity", "The button was clicked")
            Log.i("MainActivity", resources.getString(R.string.btn_was_clicked))
           // Toast.makeText(this, "The button was clicked", Toast.LENGTH_SHORT).show()
            showToast(resources.getString(R.string.btn_was_clicked))

        }

        btnSendmsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        btnShareToOtherApp.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "Text/plain"

           // startActivity(Intent.createChooser(intent, "Share to: "))
            startActivity(Intent.createChooser(intent, resources.getString(R.string.text_share_to)))

        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}