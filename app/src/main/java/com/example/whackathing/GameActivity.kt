package com.example.whackathing

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


private var boardList = mutableListOf<Mol>()

class Mol(private val mole: ImageView) {

    var isVisible = false

    private var timer = object : CountDownTimer(2000, 1000) {

        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            mole.setImageResource(0)
            var boardMole = boardList.getOrNull(generateRandom())
            while (boardMole == null || boardMole.isVisible)
                boardMole = boardList.getOrNull(generateRandom())
            boardMole.setMole()
        }
    }

    fun setMole() {
        isVisible = true
        if (Resources.moleDrawable == null)
            mole.setImageResource(R.drawable.mol)
        else
            mole.setImageDrawable(Resources.moleDrawable)
        timer.start()
        mole.setOnClickListener {
            mole.setImageResource(0)
            timer.cancel()
            var boardMole = boardList.getOrNull(generateRandom())
            while (boardMole == null || boardMole.isVisible || boardMole == this)
                boardMole = boardList.getOrNull(generateRandom())
            boardMole.setMole()
            isVisible = false
        }
    }

}
fun generateRandom(): Int {
    return (0..9).random()
}

class GameActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        initBoard()

        val boardMole = boardList.getOrNull(generateRandom())
        if (boardMole != null && !boardMole.isVisible)
            boardMole.setMole()
    }


    private fun initBoard() {

        with(boardList) {
            add(0, Mol(findViewById(R.id.a1)))
            add(1, Mol(findViewById(R.id.a2)))
            add(2, Mol(findViewById(R.id.a3)))
            add(3, Mol(findViewById(R.id.b1)))
            add(4, Mol(findViewById(R.id.b2)))
            add(5, Mol(findViewById(R.id.b3)))
            add(6, Mol(findViewById(R.id.c1)))
            add(7, Mol(findViewById(R.id.c2)))
            add(8, Mol(findViewById(R.id.c3)))
        }


        //add score, if they fail to bit 3 mol break out of the loop

    }



    fun goToHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

//    fun boardTapped(view: View){
//        if(view !is Button)
//            return
//        removeToBoard(view)
//    }

//    private fun removeToBoard(button: Button) {
//
//        if(button.text != "")
//            return
//
//    }
}