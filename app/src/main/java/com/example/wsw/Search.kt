package com.example.wsw

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(){
    var searchText by remember { mutableStateOf("Search") }

    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp))
        .border(1.dp, Color.LightGray, RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp))
        .fillMaxWidth()
        .background(color = Color.White))
    {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Icon(painter = painterResource(R.drawable.baseline_search_24,), contentDescription = "search", modifier= Modifier.padding(3.dp))
            TextField(value = searchText, onValueChange = {searchText = it}, modifier = Modifier.background(
                Color.White),  colors = TextFieldDefaults.textFieldColors(containerColor = Color.White))
        }
    }
}
