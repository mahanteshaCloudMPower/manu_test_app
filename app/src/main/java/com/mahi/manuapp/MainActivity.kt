package com.mahi.manuapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // One Button
//

    // One Preview Image
    var IVPreviewImage: ImageView? = null

    // constant to compare
    // the activity result code
    var SELECT_PICTURE = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // register the UI widgets with their appropriate IDs
      var  BSelectImage : Button= findViewById(R.id.BSelectImage)
        IVPreviewImage = findViewById(R.id.IVPreviewImage)

        // handle the Choose Image button to trigger
        // the image chooser function
        BSelectImage.setOnClickListener(View.OnClickListener { imageChooser() })
    }

    // this function is triggered when
    // the Select Image Button is clicked
    fun imageChooser() {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                val selectedImageUri = data!!.data
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage!!.setImageURI(selectedImageUri)
                }
            }
        }
    }
}
