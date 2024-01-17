package com.example.wsw

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.Text
import com.example.wsw.theme.WSWTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    WSWTheme(){
                        Button(onClick = {/*todo*/}, content={Text("poop")})
                    }
                }
            }
        }



