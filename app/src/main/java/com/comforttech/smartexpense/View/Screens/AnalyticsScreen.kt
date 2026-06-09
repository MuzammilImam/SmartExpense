package com.comforttech.smartexpense.View.Screens

import android.util.Log
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comforttech.smartexpense.Model.Analysis
import com.comforttech.smartexpense.Model.Category
import com.comforttech.smartexpense.R
import com.comforttech.smartexpense.ui.theme.colorBlue
import com.comforttech.smartexpense.ui.theme.colorWhite
import kotlinx.coroutines.time.delay

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import com.comforttech.smartexpense.ui.theme.colorpurp
import com.comforttech.smartexpense.ui.theme.colorpurple

import android.graphics.Paint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import kotlin.math.atan2
import kotlin.math.min
import kotlin.math.roundToInt



@Preview
@Composable
fun Analytics(){


   /* val categoryList = listOf(
        Category(1, "Food"),
        Category(2, "Travel"),
        Category(3, "Bills"),
        Category(4, "Shopping"),
        Category(5, "Health"),
        Category(6, "Rent"),
        Category(7, "Transport"),
        Category(8, "Entertainment")
    )
*/

    val analysis = listOf(
        Analysis("TotalSpent", 80.0),
        Analysis("Average per Day",70.0),
        Analysis("highestcategory",68.00),
        Analysis("Transactions",90.00),

    )

    val colorList = listOf(Color.Blue,Color.Green,Color.Red)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorWhite)
    ) {

        Text(
            text = stringResource(R.string.Analytics),
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 14.dp,top=18.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        animatedNameSwitcher()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp)
        ) {

            items(analysis) { item ->

                CategoryCard(item = item, onClick = {} )

                }


            }


        Card(
            modifier = Modifier
                .padding(start = 14.dp, end = 14.dp, bottom = 6.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            colors = CardDefaults.cardColors(
                containerColor = colorWhite
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ){

            Text(
                text = stringResource(R.string.Spendingbycategory),
                color = Color.LightGray,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 14.dp,top=18.dp)
            )

            //Spacer(modifier = Modifier.height(6.dp))

            PieChart(modifier = Modifier, progress =listOf(10f, 20f, 5f) , colors = colorList)
        }
        }



}

@Composable
fun CategoryCard(
    item: Analysis,
    onClick: (Analysis) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onClick(item) },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text =  item.name,
                    color = Color.Gray,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "₹${String.format("%.2f", item.amount)}",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun animatedNameSwitcher() {

    val monthNames = listOf("January", "Feburary", "March", "April", "May",
                                  "June","July","August","September","October",
                                    "November","December")


    var index by remember { mutableStateOf(0) }

    // animation state
    val transition = updateTransition(targetState = index, label = "nameTransition")

    val offsetX by transition.animateDp(label = "offset") { state ->
        if (state == index) 0.dp else 0.dp
    }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                // ⬅ LEFT
                IconButton(onClick = {

                    index = if (index == 0) {
                        monthNames.lastIndex
                    } else {
                        index - 1
                    }
                }, modifier = Modifier.background(colorpurp)) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Previous",
                        tint = colorBlue

                    )
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = monthNames[index],
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.offset(x = offsetX),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(20.dp))

                // ➡ RIGHT
                IconButton(onClick = {

                    index = (index + 1) % monthNames.size
                },modifier= Modifier.background(colorpurp)) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Next",
                        tint = colorBlue
                    )
                }
            }

}

@Composable
fun PieChart(
    point:List<Float>,
    color:List<Color>
){

    val total = point.sum()
    val propotions = point.map {
        it*100/total
    }

    val sweepAnglPerc = propotions.map{
        360 * it/100
    }
    Canvas(modifier = Modifier.fillMaxSize()
        .background(Color.White) ){

       /* drawArc(
            color= Color.Green,
            startAngle = 270f,
            sweepAngle = sweepAnglPerc[0],
            useCenter = true,
            size = Size(width = size.width,height= size.width)
        )*/

        drawArc(
            color= Color.Green,
            startAngle = 270f,
            sweepAngle = sweepAnglPerc[0],
            useCenter = true,
            size = Size(width = size.width,height= size.width)
        )
    }
}

@Preview
@Composable
fun chartview(){
PieChart(point = listOf(100f,34f),
    color = listOf(Color.Red, Color.Blue))


}
