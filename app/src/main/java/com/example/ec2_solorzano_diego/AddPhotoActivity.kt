package com.example.ec2_solorzano_diego

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.ec2_solorzano_diego.databinding.ActivityAddPhotoBinding
import com.example.ec2_solorzano_diego.databinding.ActivityMainBinding

class AddPhotoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPhotoBinding
    private lateinit var openCameraLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddPhoto.setOnClickListener {
            if (permissionValidated()) {
                openCamera()
            }

        }
        openCameraLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val photo: Bitmap = result.data?.extras?.get("data") as Bitmap
                    binding.imgPhoto.setImageBitmap(photo)
                }
            }
    }

    private fun permissionValidated(): Boolean {
        val cameraPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        val permissionList: MutableList<String> = mutableListOf()
        if(cameraPermission != PackageManager.PERMISSION_GRANTED){
            permissionList.add(android.Manifest.permission.CAMERA)
        }
        if(permissionList.isNotEmpty()){
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(),1000)
            return false
        }

        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            1000 -> {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openCamera()
                }else{
                    Toast.makeText(this, "Permiso  de camara denegado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun openCamera() {
        val intent = Intent()
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        openCameraLauncher.launch(intent)
    }
}