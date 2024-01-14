package com.example.wsw

import android.annotation.SuppressLint
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun SwitchCard(sI: SwitchK, onButtonClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal=10.dp)
            .padding(vertical=8.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .border(2.dp, MaterialTheme.colors.secondary, RoundedCornerShape(size = 12.dp))
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
                    painter = rememberAsyncImagePainter(sI.main_img),
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
                if (sI.name != null) {
                    Text(sI.name)
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxHeight().weight(1f)) {
                val radioButtonState = rememberSaveable{ mutableStateOf(false) }
                RadioButton(selected = radioButtonState.value,
                    onClick = {  radioButtonState.value = radioButtonLogic(radioButtonState.value, sI)},
                    modifier = Modifier.size(75.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colors.secondary,
                    ))
            }
        }
    }
}

fun radioButtonLogic(state: Boolean, sI: SwitchK): Boolean {
    if (state == false && MainActivity.switchCount.count < 2)
    {
        MainActivity.switchCount.add()
        if (compareItem1.flag){
            compareItem1.setInfoz(sI)
        }
        else if (compareItem2.flag){
            compareItem2.setInfoz(sI)
        }
        return true
    }
    else if(state == true && MainActivity.switchCount.count != 0)
    {
        MainActivity.switchCount.minus()
        if (!compareItem1.flag && compareItem2.flag){
            compareItem1.clearInfoz()
        }
        else if (compareItem1.flag && !compareItem2.flag){
            compareItem2.clearInfoz()
        }
        else if(!compareItem1.flag && !compareItem2.flag){
            if (compareItem1.eq(sI.name)){
                compareItem1.clearInfoz()
            }
            else if (compareItem2.eq(sI.name)){
                compareItem2.clearInfoz()
            }
        }

        return false
    }

    return false
}

@Composable
fun BottomInfo(bottom_out_force: String?, spring: String?, tac_travel: String?, price: String?,
               total_travel: String?, op_force: String?, name: String?, bio: String?,
               tac_foce: String?, type: String?, pre_travel: String?, main_img: String?, info_img: String?, promo_img: String?){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clip(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = Color.White))
    {
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement= Arrangement.Center){
            Image(
                painter = rememberAsyncImagePainter(main_img),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement= Arrangement.Center){
            if (name != null) {
                Text(name, fontSize = 30.sp)
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement= Arrangement.SpaceEvenly){
            Column {
                Row(modifier = Modifier.padding(5.dp))  {
                    if (type != null) {
                        Text(type)
                    }
                }
                Row(modifier = Modifier.padding(5.dp))  {
                    if (op_force != null) {
                        Text(op_force)
                    }
                }
                Row(modifier = Modifier.padding(5.dp))  {
                    if (total_travel != null) {
                        Text(total_travel)
                    }
                }
                Row(modifier = Modifier.padding(5.dp))  {
                    if (pre_travel != null) {
                        Text(pre_travel)
                    }
                }
            }
            Column {
                Row(modifier = Modifier.padding(5.dp))  {
                    if (tac_travel != null) {
                        Text(tac_travel)
                    }
                }
                Row(modifier = Modifier.padding(5.dp))  {
                    if (tac_foce != null) {
                        Text(tac_foce)
                    }
                }
                Row(modifier = Modifier.padding(5.dp))  {
                    if (bottom_out_force != null) {
                        Text(bottom_out_force)
                    }
                }
                Row(modifier = Modifier.padding(5.dp))  {
                    if (spring != null) {
                        Text(spring)
                    }
                }
            }
        }
        Row(horizontalArrangement= Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(10.dp)){
            Image(
                painter = rememberAsyncImagePainter(info_img),
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
fun FullCard(sI: SwitchK) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable{ mutableStateOf(false) }

    SwitchCard(sI, onButtonClicked = {isSheetOpen = !isSheetOpen})

    if (isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isSheetOpen = false}
        )
        {
                BottomInfo(
                    sI.bottom_out_force, sI.spring, sI.tac_travel, sI.price, sI.total_travel,
                    sI.op_force, sI.name, sI.bio, sI.tac_foce, sI.type, sI.pre_travel, sI.main_img,
                    sI.info_img, sI.promo_ing)
        }
    }
}