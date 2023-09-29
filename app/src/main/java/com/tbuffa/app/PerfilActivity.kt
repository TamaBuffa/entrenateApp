package com.tbuffa.app

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val btnCamara=findViewById<Button>(R.id.btnCamera)

        btnCamara.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }

       private val startForResult= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->

           if (result.resultCode == Activity.RESULT_OK){
               val intent=result.data
               val imageBitmap=intent?.extras?.get("data") as Bitmap
               val imageView=findViewById<ImageView>(R.id.ivCamera)
               imageView.setImageBitmap(imageBitmap)
           }
       }

    }


