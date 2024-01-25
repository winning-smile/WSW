package com.example.wsw.ui.cardItem

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.models.SwitchK

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
/* TODO добавить в параметры цвет для обводки */
fun TopCardItem(switch: SwitchK, viewModel: SwitchCardViewModel, onButtonClicked: () -> Unit) {
    Card(shape = RoundedCornerShape(16.dp), backgroundColor = Color.White, border = BorderStroke(2.dp, Color.White),
        modifier = Modifier.fillMaxWidth().height(80.dp).padding(7.dp).clickable(
            interactionSource = MutableInteractionSource(),
            indication = rememberRipple(bounded = true, radius = 40.dp, color = Color.DarkGray),
            onClick = onButtonClicked) , elevation = 5.dp)
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        ) {
            // Switch image
            Image(
                painter = rememberAsyncImagePainter(switch.main_img),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(16.dp))
            )
            // Switch Name
            if (switch.name != null) {
                Text(text=switch.name, modifier = Modifier.width(200.dp), maxLines = 1,
                    overflow = TextOverflow.Ellipsis,  textAlign = TextAlign.Start)
            }

            val radioButtonState = rememberSaveable{ mutableStateOf(false) }

            // Switch select for compare
            RadioButton(
                selected = radioButtonState.value,
                onClick = {radioButtonState.value = viewModel.radioButtonLogic(radioButtonState.value, switch.id)},
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}
