package com.example.whackathing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToPlay(view: View){
        val intent2 = Intent(this, GameActivity::class.java)
        startActivity(intent2)
    }

    fun sendData(view: View){
        val intent = Intent(this, SelectImageActivity::class.java)
        startActivity(intent)
    }

}