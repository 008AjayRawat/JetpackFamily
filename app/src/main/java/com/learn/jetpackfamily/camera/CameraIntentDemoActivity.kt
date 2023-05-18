package com.learn.jetpackfamily.camera

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.learn.jetpackfamily.databinding.ActivityCameraIntentDemoBinding

class CameraIntentDemoActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }


    private lateinit var viewBinding: ActivityCameraIntentDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCameraIntentDemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        viewBinding.btnTakePicture.setOnClickListener {
            dispatchTakePictureIntent()
        }

    }


    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (exc: Exception) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val bitmap = data?.extras?.get("data")
    }

}