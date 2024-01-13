package com.example.wsw

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private val viewModel: SwitchCardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    ComposeNavigation(viewModel)
                }
            }
        }


