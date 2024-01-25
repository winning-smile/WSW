package com.example.wsw.ui.topbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.theme.cityAdd
import com.example.wsw.theme.cityBackground
import com.example.wsw.theme.cityOnBackground
import com.example.wsw.theme.cityOnPrimary

@Composable
fun CompareCountButton(col: Color, viewModel: SwitchCardViewModel){
    Button(onClick = {viewModel.cv()}, content = { Text(viewModel.selectCount.toString()+ "/2") },
        modifier = Modifier.size(70.dp), border = BorderStroke(2.dp, cityAdd),
        shape = RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp), colors = ButtonColors(cityBackground, cityOnBackground, Color.LightGray, Color.DarkGray)
    )
}

@Composable
fun SearchButton(col: Color, pv: PaddingValues){
    Button(onClick = {/*todo*/}, modifier = Modifier.padding(pv).zIndex(10f),
        content = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Localized description") },
        shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 12.dp), colors = ButtonColors(col, cityOnPrimary, Color.LightGray, Color.DarkGray)
    )
}

@Composable
fun CompareButton(col: Color) {
    Button(onClick = {/*todo*/},
        content = { Icon(imageVector = Icons.Filled.FilterAlt, contentDescription = "Localized description") },
        shape = RoundedCornerShape(0.dp , 0.dp, 12.dp, 0.dp), colors = ButtonColors(col, cityOnPrimary, Color.LightGray, Color.DarkGray)
    )
}