package com.example.composepractice

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.util.toHalf
import com.example.composepractice.util.Utils

@Composable
fun FilterScreen() {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Utils.getColor("fafcff"))) {


        Column(Modifier.verticalScroll(rememberScrollState())) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp,start = 12.dp,end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                            .background(Utils.getColor("73c1ff")),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            tint = Color.White,
                            contentDescription = null
                        )

                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        "Filter by",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    )


                }


                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(12.dp))
                        , contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Clear,
                        tint = Color.Black,
                        contentDescription = null
                    )


                }


            }




            Text(
                "Price", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ), modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp, top = 24.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TestUI(listOf("100", "500", "1000", "5000"), "100")
                TestUI(listOf("500", "4000", "10000", "15000"), "500")

            }

            SliderUI()

            LowerUI()
        }


        Box(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 12.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .align(Alignment.BottomCenter)
                .background(Utils.getColor("73c1ff")),
            contentAlignment = Alignment.Center
        ) {

            Text(
                "Find a nanny!",
                style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
            )
        }

    }

}


@Composable
fun TestUI(items: List<String>, disabledValue: String) {
    var expanded by remember { mutableStateOf(false) }
//    val items = listOf("A", "B", "C", "D", "E", "F")
//    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .height(45.dp)
            .clip(RoundedCornerShape(12.dp))

            .background(
                Color.White
            ), contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .width(120.dp)
                .padding(horizontal = 8.dp)
                .clickable(onClick = { expanded = true }), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                items[selectedIndex],
            )


            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)


        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier

                .background(
                    Color.White
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    val disabledText = if (s == disabledValue) {
                        " (Disabled)"
                    } else {
                        ""
                    }
                    Text(text = s + disabledText)
                }
            }
        }
    }

}


@Composable
fun SliderUI() {

    var sliderPosition by remember { mutableStateOf(0f) }


    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            "Distance", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ), modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Slider(
            value = sliderPosition, onValueChange = {
                sliderPosition = it

            }, colors = SliderDefaults.colors(
                thumbColor = Utils.getColor("feb92d"),
                activeTickColor = Utils.getColor("feb92d"),
                disabledActiveTickColor = Utils.getColor("feb92d"),
                activeTrackColor = Utils.getColor("feb92d"),
                disabledActiveTrackColor = Utils.getColor("feb92d")

            )
        )
        Text(
            "${sliderPosition} miles", style = TextStyle(
                fontSize = 12.sp
            ), modifier = Modifier.align(Alignment.CenterHorizontally)
        )


    }

}


@Composable
fun LowerUI() {

    var onlineStatus = remember {
        mutableStateOf(false)
    }

    var ratingSelected = remember {
        mutableStateOf(false)
    }

    Column() {

        Box(
            modifier = Modifier
                .padding(12.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .padding(all = 12.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Online now",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )

                Switch(checked = onlineStatus.value, onCheckedChange = {
                    onlineStatus.value = it
                },colors = SwitchDefaults.colors(
                    checkedThumbColor = Utils.getColor("73c1ff"),
                    uncheckedThumbColor = Utils.getColor("ebebeb"),
                    uncheckedTrackColor = Utils.getColor("ebebeb")



                ))

            }


        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            "Sorting by", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            ), modifier = Modifier.padding(start = 24.dp)
        )


        Row(
            modifier = Modifier
                .padding(all = 12.dp)
                .clip(RoundedCornerShape(12.dp))
                .height(45.dp)
                .fillMaxWidth()
                .background(Utils.getColor("ebebeb")),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(150.dp)
                    .background(if (ratingSelected.value) Color.White else Utils.getColor("ebebeb"))
                    .height(45.dp)
                    .clickable {

                        if (!ratingSelected.value) ratingSelected.value = true

                    },
                contentAlignment = Alignment.Center
            ) {

                Text("Rating", style = TextStyle(fontWeight = FontWeight.Bold))

            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .width(150.dp)
                    .height(45.dp)
                    .background(if (!ratingSelected.value) Color.White else Utils.getColor("ebebeb"))
                    .clickable {

                        if (ratingSelected.value) ratingSelected.value = false

                    },
                contentAlignment = Alignment.Center
            ) {

                Text("Experience", style = TextStyle(fontWeight = FontWeight.Bold))

            }

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Additions", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp))

            Text("See all", style = TextStyle(fontSize = 12.sp, color = Color.DarkGray),modifier = Modifier.padding(top = 4.dp))

        }


        var habitList = listOf<String>(
            "Without bad habits",
            "Knows how to give first aid",
            "Multitasking and stress resistant",
            "Has own baby monitor",
            "Super ability to swaddle in the air",
            "Can take out the trash"
        )
        Box(
            modifier = Modifier
                .padding(all = 12.dp)
                .height(200.dp)

                .clip(RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .padding(bottom = 48.dp)
            ) {

                for (habit in habitList) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Checkbox(checked = false, onCheckedChange = {

                        })

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(habit, style = TextStyle(fontSize = 14.sp))


                    }


                }

            }


        }


    }


}

