package com.example.composewidgets.composeUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.composewidgets.ui.theme.caption

@Composable
fun homePage(title: String) {
    val screen = LocalConfiguration.current
    val count = remember {
        mutableStateOf(0)
    }
    Text(text = "column 1", style = caption)
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(elevation = 30.dp) {
            Text(text = title)
        }
        Text(text = "Lazy Column", style = caption)
        LazyColumn(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = count.value) { index ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.height(400.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth(0.9f)
                            .background(Color(0xFFF72307))
                            .clip(RoundedCornerShape(20.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(text = "Box Widget $index")
                    }
                    Spacer(
                        modifier = Modifier.height(40.dp)
                    )
                }
            }

        }
    }
    FloatingActionButton(
        onClick = { count.value++ },
        modifier=Modifier.
                    offset(
                        (screen.screenWidthDp/1.25).dp,
                        (screen.screenHeightDp/1.15).dp
                    ),
        contentColor = Color(0xFFF72307),
    ) {
        Text(text = "+")
    }
}


