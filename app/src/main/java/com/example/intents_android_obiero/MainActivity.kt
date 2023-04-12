package com.example.intents_android_obiero

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnSMS:Button
    lateinit var btnEmail:Button
    lateinit var btnCamera:Button
    lateinit var btnShare:Button
    lateinit var btnMpesa:Button
    lateinit var btnCall:Button
    lateinit var btnWebsite:Button
    lateinit var btnMaps:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSMS = findViewById(R.id.btnSMS)
        btnEmail = findViewById(R.id.btnEmail)
        btnCamera = findViewById(R.id.btnCamera)
        btnShare = findViewById(R.id.btnShare)
        btnMpesa = findViewById(R.id.btnMpesa)
        btnCall = findViewById(R.id.btnCall)
        btnWebsite = findViewById(R.id.btnWebsite)
        btnMaps = findViewById(R.id.btnMaps)

        btnSMS.setOnClickListener {
            val uri:Uri = Uri.parse("smsto:0702670849")
            val intent=Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Wilkommen Herlich" )
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val emailintent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "rayobiero62@gmail.com", null))
            emailintent.putExtra(Intent.EXTRA_SUBJECT, "Job Application")
            emailintent.putExtra(Intent.EXTRA_TEXT, "Job Application")
            startActivity(Intent.createChooser(emailintent, "Send Email"))
        }

        btnCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }

        btnMpesa.setOnClickListener {
            val simtoolkitIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simtoolkitIntent?.let { startActivity(it) }
        }

        btnWebsite.setOnClickListener {
            //Code to navigate from activity to another
            val open_website = Intent(this, Website_Activity::class.java)
            startActivity(open_website)
        }

    }
}