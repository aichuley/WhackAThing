package com.example.whackathing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SelectImageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectimage)
    }

    fun sendDataHome(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}