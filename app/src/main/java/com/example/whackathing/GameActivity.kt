package com.example.whackathing

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Mol(val mole: ImageView) {

    init{
        var testing: ImageView = mole;
    }

}

class GameActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }


    fun goToHome(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}