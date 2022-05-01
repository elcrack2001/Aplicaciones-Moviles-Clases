package com.example.appsem05_01_camara

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

//Antes ir a la carpeta manifests y Agregar lo de la linea 5

class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRequest = findViewById<Button>(R.id.btnRequest)

        btnRequest.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED){
            //Permiso Rechazado
            requestCameraPermision()
        }else{
            //Ya tengo permiso
            Toast.makeText(this, "Ya se cuenta con acceso a la camara", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestCameraPermision() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            //Si el usuario ya rechazo el permiso anteriormente que vaya a ajustes
            Toast.makeText(this, "Rechazo el permiso anteriormente. Habilitelo manualmente", Toast.LENGTH_SHORT).show()
        }else{
            //Si el usuario nunca ha aceptado ni rechazado, le pedimos que acepte el permiso
            Toast.makeText(this, "Debe aceptar el permiso", Toast.LENGTH_SHORT).show()
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    //Voy a "escuchar" la respuesta del usuario
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permiso aceptado por el usuario
                    //Aca, llamaria a cualquier funcionalidad que quiera hacer
                    Toast.makeText(this, "Se autorizo el acceso a la camara", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Permiso DENEGADO", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
}