package com.comforttech.smartexpense.View.Screens

import android.annotation.SuppressLint
import android.app.StatusBarManager
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comforttech.smartexpense.View.Navigations.NavigationManager
import com.comforttech.smartexpense.ui.theme.colorBlue
import com.comforttech.smartexpense.R
import com.comforttech.smartexpense.View.BottomNavigation.NavItem
import androidx.compose.ui.unit.sp
import com.comforttech.smartexpense.ui.theme.colorpurple

@Composable
fun Dashboard(navigationManager: NavigationManager) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = colorBlue
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }


    ) {
        padding->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF3F3F8))){

            item {

                HeaderSection()
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                InsightSetion()
            }

        }


    }
}

@Composable
fun HeaderSection(){

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(
            colorBlue
            // shape = RoundedCornerShape(bottomStart = )
        )
        .padding(24.dp)) {

                Text(
                    text = "Good Morning",
                    color= Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp)
        
        
                Spacer(modifier = Modifier.height(4.dp))

                Row (verticalAlignment = Alignment.CenterVertically){

                    Text(
                        text = "Client",
                        color= Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f))

                }
        
              Spacer(modifier = Modifier.height(8.dp))

             ExpenseCard()
    }

}

@Composable
fun ExpenseCard(){

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF5A50C8)
        ),
        shape = RoundedCornerShape(18.dp)
    ) {

        Column( modifier = Modifier.padding(16.dp)) {

            Text(
                text = "May 2026 — Total spent",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "¥ 84,200",
                color = Color.White,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            LinearProgressIndicator(
                progress = { 0.70f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(50)),
                color = Color.White,
                trackColor = Color.White.copy(alpha = 0.25f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "70% of ¥120,000",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 12.sp,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "¥35,800 left",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Chip("Food 32%")
                Chip("Travel 18%")
                Chip("Shop 28%")
            }
        }


        }
    }

@Composable
fun Chip(text:String){

    Box(
        modifier = Modifier
            .background(
                Color.White.copy(alpha = 0.15f),
                RoundedCornerShape(50)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}

@Composable
fun InsightSetion(){


}

@Composable
fun BottomBar(){

      val home = stringResource(R.string.NavHome)
      val analytics= stringResource(R.string.NavAnalytics)
      val budget = stringResource(R.string.NavBudget)
      val categories = stringResource(R.string.NavCategories)
      val settings = stringResource(R.string.NavSettings)


    val navItemList  = listOf(
        NavItem(home,Icons.Default.Home),
        NavItem(analytics,Icons.Default.BarChart),
        NavItem(budget,Icons.Default.AccountBalanceWallet),
        NavItem(categories,Icons.Default.Category),
        NavItem(settings,Icons.Default.Settings)
    )


    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    NavigationBar {

        navItemList.forEachIndexed { index, navItem ->
           /* NavigationBarItem(
                selected = true,
                onClick = { *//*TODO*//* },
                icon = { Icon(Icons.Default.Home, null) },
                label = { Text(text = home) }
            )

            NavigationBarItem(
                selected = false,
                onClick = { *//*TODO*//* },
                icon = { Icon(Icons.Default.BarChart, null) },
                label = { Text(text = analytics) }
            )

            NavigationBarItem(
                selected = false,
                onClick = { *//*TODO*//* },
                icon = { Icon(Icons.Default.AccountBalanceWallet, null) },
                label = { Text(text = budget) }
            )

            NavigationBarItem(
                selected = false,
                onClick = { *//*TODO*//* },
                icon = { Icon(Icons.Default.Category, null) },
                label = { Text(text = categories) }
            )

            NavigationBarItem(
                selected = false,
                onClick = { *//*TODO*//* },
                icon = { Icon(Icons.Default.Settings, null) },
                label = { Text(text = settings) }
            )
*/

            NavigationBarItem(selected = selectedIndex == index,
                onClick = { selectedIndex = index},
                icon = { Icon(imageVector = navItem.icon , contentDescription = null) },
                label = {
                    Text(text = navItem.label)
                }
            )

        }
    }
}

















