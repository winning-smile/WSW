package com.example.wsw

import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val viewModel: SwitchCardViewModel by viewModels()
    object switchCount{
        var count = 0

        fun add(){
            count += 1
        }

        fun minus(){
            count -= 1
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Color.parseColor("#253A51")
                    MyTheme{
                        ComposeNavigation(viewModel)
                    }
                }
            }
        }



