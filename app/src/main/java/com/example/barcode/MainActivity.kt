package com.example.barcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTextView = findViewById<EditText>(R.id.et_text)
        val btnGenerate = findViewById<Button>(R.id.buttonGenerate)
        val barcodeImage = findViewById<ImageView>(R.id.barcodeImage)

        btnGenerate.setOnClickListener {
            try {
                val encode = BarcodeEncoder()
                val bitmap = encode.encodeBitmap(
                    etTextView.text.toString(), BarcodeFormat.QR_CODE,
                    500, 500
                )
                barcodeImage.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}