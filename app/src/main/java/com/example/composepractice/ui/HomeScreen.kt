package com.example.composepractice.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.DateRange
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R
import com.example.composepractice.util.Utils

@Composable
fun HomeScreen() {

    Box(modifier = Modifier.fillMaxSize()
        .background(Color.White,
            ),contentAlignment = Alignment.BottomCenter){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Utils.getColor("fafcff"))
                .verticalScroll(rememberScrollState())
        ) {

            TopUI()
            MiddleUI()
            LowerUI()
        }
        BottomUI()


    }



}


@Composable
fun TopUI() {

    Column() {
        //Avatar with Name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp)
        ) {

            Box() {
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .shadow(15.dp, CircleShape)
                        .clip(CircleShape)
                        .background(Color.Blue)
                ) {
                    Image(
                        painter = painterResource(R.drawable.rock),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .matchParentSize()
                            .clip(CircleShape)                       // clip to the circle shape
                        // add a border (optional)
                    )


                }
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(CircleShape)
                        .background(Utils.getColor("abda83"))
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = CircleShape
                        )
                        .align(Alignment.BottomEnd)

                )
            }

            Text(
                "Hello, Jenny!", style = TextStyle(
                    fontSize = 24.sp, fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(start = 12.dp)
            )


        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,

            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp)
        ) {

            TextField(
                label={
                    Text("Search")
                },

                value = "",

                onValueChange = {


                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 12.dp)
                    .clip(RoundedCornerShape(size = 16.dp))
                    .background(Color.White)
                    .shadow(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent

                ),
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }

            )


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(height = 45.dp, width = 45.dp)
                    .clip(RoundedCornerShape(size = 16.dp))
                    .background(Utils.getColor("feb92d"))
            ) {

                Icon(
//                    imageVector = Icons.Filled.Person,
                    painterResource(id = R.drawable.filter),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(height = 30.dp, width = 45.dp)
                        .size(height = 30.dp, width = 45.dp)

                )

            }


        }


    }


}


@Composable
fun MiddleUI() {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .size(height = 150.dp, width = 150.dp)
                .shadow(20.dp)

                .clip(RoundedCornerShape(size = 16.dp))
                .background(Color.White)

        ) {


            Image(
                painter = painterResource(id = R.drawable.business),
                contentDescription = null, modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.BottomEnd)
            )
            Text(
                "How to find a nanny", modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(all = 8.dp)
            )


        }


        Box(
            modifier = Modifier
                .size(height = 150.dp, width = 150.dp)
                .padding(start = 8.dp)
                .shadow(20.dp)

                .clip(RoundedCornerShape(size = 16.dp))
                .background(Color.White)

        ) {


            Image(
                painter = painterResource(id = R.drawable.sir),
                contentDescription = null, modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.BottomEnd)
            )
            Text(
                "Take care for elder", modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(all = 8.dp)
            )


        }

    }

}


@Composable
fun BottomUI() {

    Box( contentAlignment = Alignment.Center) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(Color.White).align(Alignment.BottomCenter)){
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
            ) {

                Row(){


                }

                Icon(
                    modifier=Modifier.size(30.dp),
                    imageVector = Icons.Default.Home,
                    contentDescription = null, tint = Color.DarkGray
                )


                Icon(
                    modifier=Modifier.size(30.dp),
                    imageVector = Icons.Sharp.MailOutline,
                    contentDescription = null, tint = Color.DarkGray
                )

                Spacer(modifier = Modifier.width(90.dp))
                Icon(
                    modifier=Modifier.size(30.dp),

                    imageVector = Icons.Sharp.DateRange,
                    contentDescription = null, tint = Color.DarkGray
                )


                Icon(
                    modifier=Modifier.size(30.dp),

                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null, tint = Color.DarkGray
                )
                Row(){


                }






            }

        }


        Box(modifier = Modifier.padding(bottom=8.dp).size(60.dp).clip(CircleShape).background(Utils.getColor("73c1ff")),
        contentAlignment = Alignment.Center){

            Icon(
                modifier=Modifier.size(25.dp),
                imageVector = Icons.Default.Add,
            contentDescription = null,tint=Color.White)

        }


    }


}


@Composable
fun LowerUI() {

    Column() {
        Text(
            "Top babysitters!", style = TextStyle(
                fontSize = 24.sp, fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(start = 12.dp, top = 24.dp,bottom=12.dp)
        )


        LazyColumn(modifier = Modifier.height(height = 300.dp), content = {
            items(10) {

                BioUI()

            }

        })


    }


}

@Composable
fun BioUI() {
    Box(
        modifier = Modifier
            .padding(12.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Utils.getColor("ddeaf3"))
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(12.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(75.dp)
                    .shadow(15.dp, CircleShape)
                    .clip(CircleShape)
                    .background(Color.Blue)
            ) {
                Image(
                    painter = painterResource(R.drawable.rock),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .matchParentSize()
                        .clip(CircleShape)                       // clip to the circle shape
                    // add a border (optional)
                )


            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, top = 8.dp)
            ) {
                Text("Anny White", style = TextStyle(fontWeight = FontWeight.Bold))
                Text("Experience: 5 years")

                Row() {
                    Icon(
                        imageVector = Icons.Default.Star,
                        tint = Color.Green, contentDescription = null
                    )
                    Text(text = "5.0")

                }

            }


            Icon(
                imageVector = Icons.Default.ArrowForward,
                tint = Utils.getColor("73c1ff"), contentDescription = null
            )


        }


    }
}


@Composable
@Preview(showBackground = true)
fun Preview() {

    Column {

        TopUI()
        MiddleUI()

    }

}


