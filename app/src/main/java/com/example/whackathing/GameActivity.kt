package com.example.whackathing

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


private var boardList = mutableListOf<Mol>()

class Mol(val mole: ImageView) {

    var isVisible = false

    private var timer = object : CountDownTimer(1500, 1000) {

        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            mole.setImageResource(0)
            isVisible = false
            var boardMole = boardList.getOrNull(generateRandom())
            while ((boardMole == null) || boardMole.isVisible)
                boardMole = boardList.getOrNull(generateRandom())
            boardMole.setMole()
            mole.setOnClickListener{}
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
            isVisible = false
            timer.cancel()
            var boardMole = boardList.getOrNull(generateRandom())
            while (boardMole == null || boardMole.isVisible || boardMole == this)
                boardMole = boardList.getOrNull(generateRandom())
            boardMole.setMole()
            mole.setOnClickListener{}
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

        val it = boardList.iterator()
        while(it.hasNext()){
            val mole = it.next()
            mole.mole.setOnClickListener{}
        }
    }

    fun goToHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}