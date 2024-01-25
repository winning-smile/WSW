package com.example.wsw.ui.bottombar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TriangleShape() {
    Canvas(modifier = Modifier.fillMaxWidth().height(35.dp)) {
        val path = Path().apply {
            val shapeWidth = size.width
            val shapeHeight = size.height
            val circleR = 50f
            val shR = shapeWidth/2 + circleR
            val shL = shapeWidth/2 - circleR
            val test = shapeWidth/4
            val testy = shapeHeight/2

            lineTo(shL, 0f)
            //arcTo(Rect(shL, 0f, shapeHeight*(2/3), shR), 180f, -180f, true)
            //lineTo(shapeWidth, 0f)
            //lineTo(shapeWidth, shapeHeight)
            //lineTo(0f, shapeHeight)
            //lineTo(0f, 0f)
            close()
        }

        drawPath(path, Color.Blue)
    }
}