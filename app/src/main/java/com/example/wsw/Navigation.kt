package com.example.wsw

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ComposeNavigation(viewModel: SwitchCardViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "search_screen"
    ) {
        composable("search_screen") {
            SearchScreen(viewModel, navController = navController)
        }
        composable("compare_screen")
        {
            CompareScreen(viewModel, navController = navController)
        }
        composable("build_screen") {
            BuildScreen(navController = navController)
        }
    }
}

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun BottomNav(navController: NavController){
    var switch_1: ArrayList<String> = arrayListOf("N/A")
    var switch_2: ArrayList<String> = arrayListOf("N/A")

    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp))
        .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp))
        .fillMaxWidth()
        .height(60.dp)
        .background(color = Color.White))
    {
        Row (horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().fillMaxHeight()){
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight().weight(1f).clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(
                        bounded = true,
                        radius = 75.dp,
                        color = Color.DarkGray
                    ),
                    onClick = {navController.navigate("search_screen")
                    {
                        popUpTo(navController.graph.findStartDestination().id)
                        {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
                )
            ){
                Text("Search")
            }
            VerticalDivider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.fillMaxHeight())
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight().weight(1f).clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(
                        bounded = true,
                        radius = 75.dp,
                        color = Color.DarkGray
                    ),
                    onClick = { navController.navigate("compare_screen"){
                        popUpTo(navController.graph.findStartDestination().id)
                        {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }}
                )){
                Text("Compare")
            }
            VerticalDivider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.fillMaxHeight())
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight().weight(1f).clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(
                        bounded = true,
                        radius = 75.dp,
                        color = Color.DarkGray
                    ),
                    onClick = { navController.navigate("build_screen"){
                        popUpTo(navController.graph.findStartDestination().id)
                        {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }}
                )){
                Text("Build")
            }
        }
    }
}
