package com.example.wsw

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

object compareItem1{
    var info: SwitchK = SwitchK("N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A", "N/A","N/A","N/A")
    var flag:Boolean = true

    fun setInfoz(newInfo: SwitchK){
        info = newInfo
        flag = false
    }

    fun clearInfoz(){
        info = SwitchK("N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A")
        flag = true
    }

    fun eq(name: String?): Boolean {
        return name == info.name
    }
}

object compareItem2{
    var info: SwitchK = SwitchK("N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A", "N/A","N/A","N/A")
    var flag:Boolean = true

    fun setInfoz(newInfo: SwitchK){
        info = newInfo
        flag = false
    }

    fun clearInfoz(){
        info = SwitchK("N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A")
        flag = true
    }

    fun eq(name: String?): Boolean{
        return name == info.name
    }
}

@Composable
fun CompareScreen(viewModel: SwitchCardViewModel, navController: NavController) {
    Scaffold(bottomBar = { BottomNav(navController) },) {  innerPadding ->
        Column(modifier = Modifier.fillMaxWidth().padding(innerPadding).verticalScroll(rememberScrollState())){
            CompareImageView(compareItem1.info.main_img, compareItem2.info.main_img)
            CompareItemView("Name", compareItem1.info.name, compareItem2.info.name, "name")
            CompareItemView("Type", compareItem1.info.type, compareItem2.info.type, "type")
            CompareItemView("Operating Force", compareItem1.info.op_force, compareItem2.info.op_force, "opforce")
            CompareItemView("Total Travel", compareItem1.info.total_travel, compareItem2.info.total_travel, "ttravel")
            CompareItemView("Pre-Travel", compareItem1.info.pre_travel, compareItem2.info.pre_travel, "ptravel")
            CompareItemView("Tactile Travel", compareItem1.info.tac_travel, compareItem2.info.tac_travel, "tactravel")
            CompareItemView("Tactile Force", compareItem1.info.tac_foce, compareItem2.info.tac_foce, "tacforce")
            CompareItemView("Bottom-out Force", compareItem1.info.bottom_out_force, compareItem2.info.bottom_out_force, "botforce")
            CompareItemView("Spring", compareItem1.info.spring, compareItem2.info.spring, "spring")
            CompareItemView("img_info", "N/A", "N/A", "name")
        }
    }

}

@Composable
fun CompareItemView(name:String, param1:String?, param2: String?, flag:String){

    Column(Modifier.fillMaxWidth().padding(vertical = 5.dp, horizontal = 5.dp)){
        Row(horizontalArrangement = Arrangement.Center,
            modifier= Modifier.clip(shape = RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp)).fillMaxWidth().background(
                MaterialTheme.colors.onPrimary)
                .height(35.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Text(name, fontSize = 20.sp, fontWeight = FontWeight.W700)
            if (flag != "name" ){
                Icon(painterResource(R.drawable.baseline_info_24), "WSW")
            }
        }
        HorizontalDivider(
            color = MaterialTheme.colors.secondary,
            thickness = 2.dp,
        )
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier= Modifier.clip(shape = RoundedCornerShape(0.dp, 0.dp, 12.dp, 12.dp)).fillMaxWidth().background(MaterialTheme.colors.surface).
            height(35.dp),
            verticalAlignment = Alignment.CenterVertically) {
            if (param1 != null) {
                Text(param1)
            }
            if (param2 != null) {
                Text(param2)
            }
        }
    }
}

@Composable
fun CompareImageView(src1: String?, src2: String?){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
        Image(painter= rememberAsyncImagePainter(src1), "poop", contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f).size(screenWidth/2.5f)
                .clip(RoundedCornerShape(16.dp)))
        Image(painter= rememberAsyncImagePainter(src2), "poop",contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f).size(screenWidth/2.5f)
                .clip(RoundedCornerShape(16.dp)))
    }
}
