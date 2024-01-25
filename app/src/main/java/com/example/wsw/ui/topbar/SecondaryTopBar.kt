package com.example.wsw.ui.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.theme.newBackground

@Composable
fun WSSecondaryTopBar(col: Color, innerPadding: PaddingValues, viewModel: SwitchCardViewModel){

    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(innerPadding).zIndex(2f).offset(y = (-4).dp)){{}
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.Start) { CompareButton(col) }
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) { CompareCountButton(col, viewModel) }
        //Column(Modifier.weight(1f), horizontalAlignment = Alignment.End) { SearchButton(col) }
    }
}

@Preview
@Composable
fun HiddenTopBar(){
    Row(modifier = Modifier.fillMaxWidth().height(60.dp).background(newBackground).padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        var text by remember { mutableStateOf("Hello") }
        Row(modifier = Modifier.padding(horizontal = 5.dp).weight(1f)){
            TextField(value = text, onValueChange = { text = it }, modifier = Modifier.clip(
                RoundedCornerShape(20.dp)).background(Color.White)
            )
        }
        Row(modifier = Modifier.padding(horizontal = 5.dp).weight(1f)){
            TextField(value = text, onValueChange = { text = it }, modifier = Modifier.clip(
                RoundedCornerShape(20.dp)).background(Color.White)
            )
        }
    }
}