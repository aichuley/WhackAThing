package com.example.whackathing

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat


class Mol(val mole: ImageView) {

   var timer =  object : CountDownTimer(3000, 1000) {

        override fun onTick(millisUntilFinished: Long) {
            //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
        }

        override fun onFinish() {
            //mTextField.setText("done!")
            mole!!.setImageResource(0)
        }
    }.start()

    fun getImage() : ImageView {
        return mole
    }

    fun setMole() {
        mole!!.setImageResource(R.drawable.mol)
        mole!!.setOnClickListener {
            mole!!.setImageResource(0)
        }
    }

}


class GameActivity: AppCompatActivity() {

    private var boardList = mutableListOf<Mol>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        initBoard()
    }


    private fun initBoard() {

        boardList.add(0,Mol(findViewById<ImageView>(R.id.a1)))
        boardList.add(1,Mol(findViewById<ImageView>(R.id.a2)))
        boardList.add(2,Mol(findViewById<ImageView>(R.id.a3)))
        boardList.add(3,Mol(findViewById<ImageView>(R.id.b1)))
        boardList.add(4,Mol(findViewById<ImageView>(R.id.b2)))
        boardList.add(5,Mol(findViewById<ImageView>(R.id.b3)))
        boardList.add(6,Mol(findViewById<ImageView>(R.id.c1)))
        boardList.add(7,Mol(findViewById<ImageView>(R.id.c2)))
        boardList.add(8,Mol(findViewById<ImageView>(R.id.c3)))

//        val boardMole = boardList.getOrNull(generateRandom())
//        boardMole!!.setMole()

//        var timer =  object : CountDownTimer(2000, 1000) {
//
//            override fun onTick(millisUntilFinished: Long) {
//                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
//            }
//
//            override fun onFinish() {
//                //mTextField.setText("done!")
//                //!!.setImageResource(0)
////                val boardMole = boardList.getOrNull(generateRandom())
////
////                boardMole!!.setMole()
//
//            }
//        }.start()

//        for(i in 1..3) {
//
//            val boardMole = boardList.getOrNull(generateRandom())
//            boardMole!!.setMole()
//
//        }

        while(true) {
            val boardMole = boardList.getOrNull(generateRandom())
            boardMole!!.setMole()
        }

        //add score, if they fail to bit 3 mol break out of the loop



//        currImg!!.setImageResource(R.drawable.mol)
//        currImg!!.setOnClickListener {
//            currImg!!.setImageResource(0)
//        }

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