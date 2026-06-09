package com.comforttech.smartexpense.View.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comforttech.smartexpense.R
import com.comforttech.smartexpense.ui.theme.colorBlue
import androidx.compose.runtime.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.DirectionsTransit
import androidx.compose.material.icons.outlined.ElectricBolt
import androidx.compose.material.icons.outlined.MonitorHeart
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.SportsEsports
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.comforttech.smartexpense.Model.Category
import com.comforttech.smartexpense.View.Navigations.NavigationManager
import com.comforttech.smartexpense.ui.theme.colorWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpense(navController: NavController) {

    val back = stringResource(R.string.Back)
    var amount by remember {
        mutableStateOf("")
    }
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    val categoryList = listOf(
        Category(1, "Travel",Icon(
            imageVector = Icons.Outlined.DirectionsTransit,
            contentDescription = "Travel",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF3B82F6)
        ) ),
        Category(2, "Food",Icon(
            imageVector = Icons.Outlined.Restaurant,
            contentDescription = "Food",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFFEF4444)
        )),
        Category(3, "Shopping", Icon(
            imageVector = Icons.Outlined.ShoppingBag,
            contentDescription = "Shopping",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF10B981)
        )),
        Category(4, "Bills",Icon(
            imageVector = Icons.Outlined.ElectricBolt,
            contentDescription = "Bills",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFFF59E0B)
        )),
        Category(5, "Health", Icon(
            imageVector = Icons.Outlined.MonitorHeart,
            contentDescription = "Health",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFFEC4899)
        )),
        Category(8, "Sports",Icon(
            imageVector = Icons.Outlined.SportsEsports,
            contentDescription = "Fun",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF7C3AED)
        )),
        Category(9, "Other", Icon(
            imageVector = Icons.Outlined.Category,
            contentDescription = "Other",
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF6B7280)
        ))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F3F8))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorBlue)
                .weight(1.0f)
        ) {


            //IconButton(onClick = {}) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White.copy(alpha = 0.8f)

                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = back,
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 22.sp
                    )
                }


            Text(
                text = stringResource(R.string.AddExpense),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 14.dp,top=18.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = stringResource(R.string.Amount),
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    BasicTextField(
                        value = amount,
                        onValueChange = {
                            if (it.all { c -> c.isDigit() && it.length<=12}) amount = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                             imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                // Save amount here
                            }
                        ),
                        textStyle = TextStyle(
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 32.sp
                        ),
                        decorationBox = { innerTextField ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                //if (amount.isEmpty()) {
                                    Text(
                                        text =  if (amount.isEmpty()) "0" else amount,
                                        color = Color.White.copy(alpha = 0.5f),
                                        fontSize = 32.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                showBottomSheet = true
                                            }
                                    )
                                //}

                                innerTextField()
                            }
                        })

                }

            }
            //}


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {

            Text(
                text = stringResource(R.string.category),
                color = Color.Black.copy(alpha = 0.5f),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 14.dp,top=18.dp)
            )

            CategoryGrid(categoryList)
        }

    }

    if (showBottomSheet) {

        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false }
        ) {

            NumberPad(
                amount = amount,
                onChange = { newValue ->
                    if (newValue.length <= 12) {
                        amount = newValue
                    }
                },
                onSave = {
                    showBottomSheet = false
                }
            )
        }
    }


}

@Composable
fun CategoryGrid(categoryList:List<Category>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {

        items(categoryList) { category ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {

                        Log.d("Category", category.name)

                        // Later you can pass the whole entity
                    }
            ) {

                /*Icon(
                    imageVector = ImageVector(category.imageRes),
                    contentDescription = category.name,
                    modifier = Modifier.size(60.dp)
                )*/

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = category.name,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun NumberPad(
    amount: String,
    onChange: (String) -> Unit,
    onSave: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(colorWhite.copy(alpha = 0.4f))
    ) {

        // Row 1
        Row(
            Modifier.fillMaxWidth()
           ,horizontalArrangement = Arrangement.SpaceEvenly) {
            Key("1") { onChange(amount + "1") }
            Key("2") { onChange(amount + "2") }
            Key("3") { onChange(amount + "3") }
        }

        // Row 2
        Row(
            Modifier.fillMaxWidth()
           ,horizontalArrangement = Arrangement.SpaceEvenly) {
            Key("4") { onChange(amount + "4") }
            Key("5") { onChange(amount + "5") }
            Key("6") { onChange(amount + "6") }
        }

        // Row 3
        Row(Modifier.fillMaxWidth()
            ,horizontalArrangement = Arrangement.SpaceEvenly) {
            Key("7") { onChange(amount + "7") }
            Key("8") { onChange(amount + "8") }
            Key("9") { onChange(amount + "9") }
        }

        // Row 4
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Key("⌫") {
                if (amount.isNotEmpty()) {
                    onChange(amount.dropLast(1))
                }
            }

            Key("0") {
                onChange(amount + "0")
            }
            Key(".") {
                onChange(amount + ".")
            }

        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onSave,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorBlue)
        ) {
            Text(
                text = stringResource(R.string.SaveExpense),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)

        }

        Spacer(modifier = Modifier.height(22.dp))
    }
}

@Composable
fun Key(
    text: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(6.dp)
            .size(70.dp)
            .clickable { onClick() },
                colors = CardDefaults.cardColors(
                containerColor = Color.White
                ),
        shape = RoundedCornerShape(12.dp)
    ) {

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()) {
            Text(text = text, fontSize = 22.sp,  color = Color.Black,
                textAlign = TextAlign.Center)
        }
    }
}



