package com.example.wsw.ui.cardItem

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun FullCard() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable{ mutableStateOf(false) }

    TopCardItem(onButtonClicked = {isSheetOpen = !isSheetOpen})

    if (isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false},
            modifier = Modifier.padding(vertical = 40.dp)
        )
        {
            bottomCardItem()
        }
    }
}