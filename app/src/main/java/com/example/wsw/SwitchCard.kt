package com.example.wsw

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun SwitchCard(onButtonClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal=10.dp)
            .padding(vertical=8.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .border(2.dp, Color.LightGray, RoundedCornerShape(size = 12.dp))
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth().clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(
                    bounded = false,
                    radius = 100.dp,
                    color = Color.DarkGray
                ),
                onClick = onButtonClicked
            )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxHeight().weight(1f)) {
                Image(
                    painter = painterResource(R.drawable.static_example),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight().weight(1f)) {
                Text("V3 Pro Fairy Silent")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxHeight().weight(1f)) {
                val radioButtonState = remember { mutableStateOf(false) }
                RadioButton(selected = radioButtonState.value, onClick = { radioButtonState.value = !radioButtonState.value },
                    modifier = Modifier.size(75.dp))
            }
        }
    }
}

@Composable
fun BottomInfo(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clip(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = Color.White))
    {
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement= Arrangement.Center){
            Image(
                painter = painterResource(R.drawable.static_example),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement= Arrangement.Center){
            Text("Akko Fairy Switch", fontSize = 30.sp)
        }
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement= Arrangement.SpaceEvenly){
            Column {
                Row(modifier = Modifier.padding(5.dp))  { Text("Type: Linear") }
                Row(modifier = Modifier.padding(5.dp))  { Text("Operating Force: 50gf ± 5gf") }
                Row(modifier = Modifier.padding(5.dp))  { Text("Total Travel: 3.3mm") }
                Row(modifier = Modifier.padding(5.dp))  { Text("Pre-Travel: 2.0 ± 0.5mm") }
            }
            Column {
                Row(modifier = Modifier.padding(5.dp))  { Text("Tactile Travel: N/A") }
                Row(modifier = Modifier.padding(5.dp))  { Text("Tactile Force: N/A") }
                Row(modifier = Modifier.padding(5.dp))  { Text("Bottom-out Force: N/A") }
                Row(modifier = Modifier.padding(5.dp))  { Text("Spring: N/A") }
            }
        }
        Row(horizontalArrangement= Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(10.dp)){
            Image(
                painter = painterResource(R.drawable.static_info_example),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(25.dp))
            )
        }
        Row(horizontalArrangement= Arrangement.Center,modifier = Modifier.fillMaxWidth().padding(10.dp)){
            Text("Analogues: Akko V3 Crystal Pro Switch")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullCard() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable{ mutableStateOf(false) }
    Log.d("Do", sheetState.toString())
    SwitchCard(onButtonClicked = {isSheetOpen = !isSheetOpen; Log.d("posle", sheetState.toString())})

    if (isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false}
        )
        {
            BottomInfo()
        }
    }
}