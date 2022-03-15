package com.example.composepractice

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {

    val mainActivityViewModel:MainActivityViewModel = MainActivityViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FormNameUI(applicationContext,mainActivityViewModel)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Hii from Jetpack Compose",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.White, fontSize = 24.sp
            )
        )
        Box(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .size(
                    width = 150.dp,
                    height = 150.dp
                )
                .background(color = Color.Green)
        )
        Text(
            "Good Job", style = TextStyle(fontStyle = FontStyle.Italic),
            color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(vertical = 18.dp)
        )


    }
}


@Composable
fun FormNameUI(context: Context, mainActivityViewModel: MainActivityViewModel) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        var name by remember { mutableStateOf(TextFieldValue("")) }
        var namePan by remember { mutableStateOf(TextFieldValue("")) }
        var singleChecked by remember { mutableStateOf(false) }
        var marriedChecked by remember { mutableStateOf(false) }
        var adhaarNo by remember { mutableStateOf(TextFieldValue("")) }
        var panNo by remember { mutableStateOf(TextFieldValue("")) }
        var marriedStatus by remember { mutableStateOf("Single") }


        Text(
            "Form 218", style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold, fontSize = 24.sp
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(all = 12.dp)
        )


        Image(
            painter = rememberImagePainter("https://indianmasterminds.com/wp-content/uploads/2021/12/goii.jpg"),
            contentDescription = null,

            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
                .scale(1f)
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)
        )


        OutlinedTextField(
            value = name,
            onValueChange = { it ->
                name = it

            },
            label = { Text("Name") },
            placeholder = { Text("Abc") },
            modifier = Modifier.padding(top = 12.dp), colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White

            )
        )

        OutlinedTextField(
            value = namePan,
            onValueChange = { it ->
                namePan = it

            },
            label = { Text("Name as Pan Card") },
            placeholder = { Text("ABC RAWAT") },
            modifier = Modifier.padding(top = 12.dp), colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White

            )
        )

        Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,modifier = Modifier.padding(horizontal = 18.dp)){
            Image(
                painter = rememberImagePainter("https://www.jansatta.com/wp-content/uploads/2021/12/Aadhar-Card-Update-.jpg"),
                contentDescription = null,

                modifier = Modifier
                    .size(width = 45.dp, height = 50.dp)
                    .scale(1f)
                    .padding(top = 10.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))
            OutlinedTextField(
                value = adhaarNo,
                onValueChange = { it ->
                    adhaarNo = it

                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Aadhar Number") },
                placeholder = { Text("2222 2222 2222") },
                modifier = Modifier.padding(top = 12.dp), colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White

                )
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,modifier = Modifier.padding(horizontal = 18.dp)){
            Image(
                painter = rememberImagePainter("https://5.imimg.com/data5/TP/US/MU/SELLER-51778781/pan-card-500x500.jpg"),
                contentDescription = null,

                modifier = Modifier
                    .size(width = 45.dp, height = 50.dp)
                    .scale(1f)
                    .padding(top = 10.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))
            OutlinedTextField(
                value = panNo,
                onValueChange = { it ->
                    panNo = it

                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Pan Number") },
                placeholder = { Text("AAAA59664A") },
                modifier = Modifier.padding(top = 12.dp), colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White

                )
            )
        }

        Divider(thickness = 2.dp,modifier = Modifier.padding(top = 12.dp))

        Text(
            "Marital status ", style = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 12.dp, top = 12.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 12.dp)
        ) {

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {

                Checkbox(checked = singleChecked, onCheckedChange = {
                    if (!marriedChecked){
                        marriedStatus = "Single"
                        singleChecked = it
                    }
                })
                Text("Single")

            }

            Box(modifier = Modifier.width(24.dp))

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {

                Checkbox(checked = marriedChecked, onCheckedChange = {
                    if (!singleChecked) {
                        marriedStatus = "Married"
                        marriedChecked = it
                    }
                })
                Text("Married")

            }

        }



        Button(onClick = {
            mainActivityViewModel.showData(context = context,
            msg = "Name: ${name.text}, Pan Name: ${namePan.text}," +
                    " Adhaar No: ${adhaarNo.text} Pan no: ${panNo.text}, Married Status: ${marriedStatus}")

        }, modifier = Modifier.padding(top = 12.dp,bottom = 12.dp)) {

            Text("Submit", style = TextStyle(color = Color.White))


        }


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
//        FormNameUI()
    }
}