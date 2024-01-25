package com.example.wsw.ui.cardItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.wsw.models.SwitchK
import com.example.wsw.theme.newBackground

@Composable
fun bottomCardItem(switch: SwitchK) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(5.dp).background(newBackground)
    ) {
        Image(
            rememberAsyncImagePainter(switch.info_img),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        switch.name?.let { Text(it, modifier = Modifier.padding(vertical = 5.dp)) }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Text("Type: " + switch.type, modifier = Modifier.padding(vertical = 3.dp))
                Text("Operating Force: " + switch.op_force, modifier = Modifier.padding(vertical = 3.dp))
                Text("Tactile Force: " + switch.tac_foce, modifier = Modifier.padding(vertical = 3.dp))
                Text("Bottom-out Force: " + switch.bottom_out_force, modifier = Modifier.padding(vertical = 3.dp))
                Text("Total Travel: " + switch.total_travel, modifier = Modifier.padding(vertical = 3.dp))
                Text("Tactile Travel: " + switch.tac_travel, modifier = Modifier.padding(vertical = 3.dp))
                Text("Pre-Travel: " + switch.pre_travel, modifier = Modifier.padding(vertical = 3.dp))
                Text("Spring: " + switch.spring, modifier = Modifier.padding(vertical = 3.dp))
            }
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}