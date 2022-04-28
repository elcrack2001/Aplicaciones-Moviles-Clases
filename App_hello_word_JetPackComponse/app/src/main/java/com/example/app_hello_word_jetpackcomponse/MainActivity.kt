package com.example.app_hello_word_jetpackcomponse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_hello_word_jetpackcomponse.ui.theme.App_hello_word_JetPackComponseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Column() {
                Text(text = "Este es mi primer programa...", style = MaterialTheme.typography.h4)
                PersonalData(name = "Mark Albert")
            }
        }
    }
}

@Composable
private fun PersonalData(name : String){
    MaterialTheme(){
        Column() {
            Text(text = "Mi nombre es $name")
            Text(text = "Seccion WX71")
            Text(text = "Viernes 01/04....")
        }
    }
}

@Preview
@Composable
fun PreviewPersonalData(){
    PersonalData(name = "App para Dispositivos Moviles")
}