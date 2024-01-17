package com.example.wsw.ui.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun topAppBarView() {
    Column{
        WSPrimaryTopBar()
        WSSecondaryTopBar()
    }
}