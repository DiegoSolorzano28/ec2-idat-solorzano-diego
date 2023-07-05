package com.example.ec2_solorzano_diego

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.ec2_solorzano_diego.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCamara.setOnClickListener {
            val intent = Intent(this, AddPhotoActivity::class.java)
            startActivity(intent)
        }

        binding.btnAddAddress.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java )
            startActivity(intent)

        }

    }


}