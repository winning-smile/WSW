package com.example.wsw.ui.cardItem

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.models.SwitchK
import com.example.wsw.theme.newBackground


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullCard(switch: SwitchK, viewModel: SwitchCardViewModel) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var isSheetOpen by rememberSaveable{ mutableStateOf(false) }


    TopCardItem(switch, viewModel) { isSheetOpen = !isSheetOpen }

    if (isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false},
            containerColor = newBackground
        )
        {
            bottomCardItem(switch)
        }
    }
}
