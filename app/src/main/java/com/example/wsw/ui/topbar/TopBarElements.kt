package com.example.wsw.ui.topbar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CompareCountButton(){
    Button(onClick = {/*todo*/}, content = { Text("0/2") },
        modifier = Modifier.clip(RoundedCornerShape(12.dp))
    )
}

@Composable
fun SearchButton(){
    Button(onClick = {/*todo*/},
        content = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Localized description") },
        shape = RoundedCornerShape(12.dp, 0.dp, 0.dp, 12.dp)
    )
}

@Composable
fun CompareButton() {
    Button(onClick = {/*todo*/},
        content = { Icon(imageVector = Icons.Filled.FilterAlt, contentDescription = "Localized description") },
        shape = RoundedCornerShape(0.dp , 12.dp, 12.dp, 0.dp)
    )
}