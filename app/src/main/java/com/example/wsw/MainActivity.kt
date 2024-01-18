package com.example.wsw

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.theme.WSWTheme
import com.example.wsw.ui.cardItem.FullCard

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    WSWTheme(){
                            FullCard()
                        }
                    }
                }
            }



