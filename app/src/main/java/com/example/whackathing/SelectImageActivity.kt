package com.example.whackathing

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class SelectImageActivity : AppCompatActivity(){

    private lateinit var selectImageButton: Button
    private lateinit var previewImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectimage)

        selectImageButton = findViewById(R.id.selectImageButton)
        previewImage = findViewById(R.id.previewImage)

        selectImageButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            resultLauncher.launch(intent)
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