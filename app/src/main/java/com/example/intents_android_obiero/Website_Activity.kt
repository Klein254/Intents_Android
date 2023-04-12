package com.example.intents_android_obiero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Website_Activity : AppCompatActivity() {

    lateinit var myWeb:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)

        myWeb = findViewById(R.id.m_web)

        val webSettings = myWeb.settings
        webSettings.javaScriptEnabled = true
        myWeb.loadUrl("https://klein254.github.io/Shop/")

    }
}