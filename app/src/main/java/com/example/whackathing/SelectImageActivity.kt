package com.example.whackathing

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts


class SelectImageActivity : AppCompatActivity(){

    private lateinit var selectImageButton: Button
    private lateinit var previewImage: ImageView
    private lateinit var colorSquare: ImageView
    private lateinit var backgroundColor: RadioGroup
    private lateinit var newImage: Uri

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
                newImage = data?.data!!
            }
    }

    fun sendDataHome(view: View){
        if(newImage != null) {
            val inputStream = this.contentResolver.openInputStream(newImage)
            val newDrawable = Drawable.createFromStream(inputStream, newImage.toString())
            Resources.moleDrawable = newDrawable
        }
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}