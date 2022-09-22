package com.example.whackathing

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Mol(val mole: ImageView) {

    init{
        var testing: ImageView = mole;
    }

}

class GameActivity: AppCompatActivity() {

    private var boardList = mutableListOf<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        initBoard()
    }


    private fun initBoard() {

        boardList.add(0,findViewById<Button>(R.id.a1))
        boardList.add(1,findViewById<Button>(R.id.a2))
        boardList.add(2,findViewById<Button>(R.id.a3))
        boardList.add(3,findViewById<Button>(R.id.b1))
        boardList.add(4,findViewById<Button>(R.id.b2))
        boardList.add(5,findViewById<Button>(R.id.b3))
        boardList.add(6,findViewById<Button>(R.id.c1))
        boardList.add(7,findViewById<Button>(R.id.c2))
        boardList.add(8,findViewById<Button>(R.id.c3))
    }

    fun goToHome(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun boardTapped(view: View){
        if(view !is Button)
            return
        removeToBoard(view)
    }

    private fun removeToBoard(button: Button) {

        if(button.text != "")
            return

    }
}