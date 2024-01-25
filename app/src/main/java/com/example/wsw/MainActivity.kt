package com.example.wsw

import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.screens.searchScreen
import com.example.wsw.theme.WSWTheme

class MainActivity : AppCompatActivity() {
    private val viewModel: SwitchCardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Color.parseColor("#e7eefb")
            window.navigationBarColor = Color.parseColor("#432344")
            val controller = WindowInsetsControllerCompat(window, window.decorView)
            controller.isAppearanceLightStatusBars = true
                    WSWTheme(){
                            searchScreen(viewModel)
                        }
                    }
                }
            }



