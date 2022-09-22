package com.example.whackathing

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.result.contract.ActivityResultContracts


class SelectImageActivity : AppCompatActivity(){

    private lateinit var selectImageButton: Button
    private lateinit var previewImage: ImageView
    private lateinit var colorSquare: ImageView
    private lateinit var backgroundColor: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectimage)

        selectImageButton = findViewById(R.id.selectImageButton)
        previewImage = findViewById(R.id.previewImage)
        colorSquare = findViewById(R.id.colorSquare)
        backgroundColor = findViewById(R.id.backgroundColor)

        selectImageButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            resultLauncher.launch(intent)
        }

        backgroundColor.setOnCheckedChangeListener {_, checkedId -> val radio: RadioButton? = findViewById(checkedId)
            val newColor = when(radio?.id) {
                R.id.white -> R.drawable.rectangle_white
                R.id.green -> R.drawable.rectangle_green
                R.id.black -> R.drawable.rectangle_black
                else -> R.drawable.rectangle_pink
            }
            colorSquare.setImageResource(newColor)
        }


    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                previewImage.setImageURI(data?.data)
            }
    }

    fun sendDataHome(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}