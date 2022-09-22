package com.example.whackathing

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class Mol(val mole: ImageView) {

    init{
        var testing: ImageView = mole;
    }

}

class GameActivity: AppCompatActivity() {

    private var boardList = mutableListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        initBoard()
    }


    private fun initBoard() {

        boardList.add(0,findViewById<ImageView>(R.id.a1))
        boardList.add(1,findViewById<ImageView>(R.id.a2))
        boardList.add(2,findViewById<ImageView>(R.id.a3))
        boardList.add(3,findViewById<ImageView>(R.id.b1))
        boardList.add(4,findViewById<ImageView>(R.id.b2))
        boardList.add(5,findViewById<ImageView>(R.id.b3))
        boardList.add(6,findViewById<ImageView>(R.id.c1))
        boardList.add(7,findViewById<ImageView>(R.id.c2))
        boardList.add(8,findViewById<ImageView>(R.id.c3))


        var currImg = boardList.getOrNull(generateRandom())

        currImg!!.setImageResource(R.drawable.mol)
        currImg!!.setOnClickListener {
            currImg!!.setImageResource(0);
        }

    }

    fun generateRandom(): Int{
        return (0..9).random()
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