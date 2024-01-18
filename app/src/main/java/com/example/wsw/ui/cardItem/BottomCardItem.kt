package com.example.wsw.ui.cardItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wsw.R

@Composable
fun bottomCardItem(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(5.dp).background(Color.LightGray).verticalScroll(
            ScrollState(0)
        )){
        Image(painter = painterResource(R.drawable.static_example), contentDescription = null, contentScale = ContentScale.Crop,
            modifier = Modifier.padding(vertical = 15.dp).size(150.dp).clip(RoundedCornerShape(16.dp)))
        Text("Akko Fairy Switch", modifier = Modifier.padding(vertical = 5.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)){
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(vertical = 10.dp)) {
                Text("Type: Linear", modifier = Modifier.padding(vertical = 3.dp))
                Text("Operating Force: 50gf ± 5gf", modifier = Modifier.padding(vertical = 3.dp))
                Text("Tactile Force: N/A", modifier = Modifier.padding(vertical = 3.dp))
                Text("Bottom-out Force: N/A", modifier = Modifier.padding(vertical = 3.dp))
            }
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(vertical = 10.dp)) {
                Text("Total Travel: 3.3mm", modifier = Modifier.padding(vertical = 3.dp))
                Text("Tactile Travel: N/A", modifier = Modifier.padding(vertical = 3.dp))
                Text("Pre-Travel: 2.0 ± 0.5mm", modifier = Modifier.padding(vertical = 3.dp))
                Text("Spring: N/A", modifier = Modifier.padding(vertical = 3.dp))
            }

        }

        Image(painterResource(R.drawable.static_info_example), contentDescription = null, modifier = Modifier.padding(vertical = 5.dp))
        Spacer(modifier = Modifier.height(100.dp))
    }
}