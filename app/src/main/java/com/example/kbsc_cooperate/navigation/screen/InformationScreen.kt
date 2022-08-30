package com.example.kbsc_cooperate.navigation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.R

@Composable
fun InformationScreen(navController: NavController, onBackCLick: () -> Unit) {
    Column(modifier = Modifier.background(color= Color.White)) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TopAppBar(
                modifier = Modifier.padding(bottom = 40.dp),
                elevation = 3.dp,
                backgroundColor = Color(0xFF8BB9FF),
                title = {
                    Text(text = "내 정보", color = Color.White, fontSize = 20.sp)
                },
                navigationIcon = {
                    IconButton(onClick = onBackCLick) {
                        Icon(Icons.Filled.ArrowBack,null, tint = Color.White)
                    }
                },
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_account_circle),
                contentDescription = "Account Logo",
                modifier = Modifier.size(150.dp)
            )
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                var textState by remember { mutableStateOf("") }
                var textState2 by remember { mutableStateOf("") }
                var textState3 by remember { mutableStateOf("") }

                val localFocusManager = LocalFocusManager.current
                    OutlinedTextField(
                        value = textState, onValueChange = {textState =it },
                        label ={ Text(text = "이름", color = Color.DarkGray) },
                        trailingIcon= { Text("변경", style = TextStyle(fontSize = 10.sp, textDecoration = TextDecoration.Underline))},
                       keyboardOptions= KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                localFocusManager.clearFocus()
                            }
                        ),
                        modifier = Modifier
                            .padding(bottom = 40.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent)
                    )
                OutlinedTextField(
                    value = textState2, onValueChange = {textState2 =it },
                    label ={ Text(text = "전화 번호", color = Color.DarkGray) },
                    trailingIcon= { Text("변경", style = TextStyle(fontSize = 10.sp, textDecoration = TextDecoration.Underline))},
                    keyboardOptions= KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        localFocusManager.clearFocus()
                    }
                ),
                    modifier = Modifier
                        .padding(bottom = 40.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent)
                )
                OutlinedTextField(
                    value = textState3, onValueChange = {textState3 =it },
                    label ={ Text(text = "이메일", color = Color.DarkGray) },
                    trailingIcon= { Text("변경", style = TextStyle(fontSize = 10.sp, textDecoration = TextDecoration.Underline))},
                    keyboardOptions= KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            localFocusManager.clearFocus()
                        }
                    ),
                    modifier = Modifier
                        .padding(bottom = 40.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent)
                )
                Button(
                    onClick = {/*TODO 예약목록*/},
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .height(50.dp)
                        .width(280.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text("예약 목록", fontWeight = FontWeight.Bold, color = Color.DarkGray)
                }
                }
            }
        }
    }

@Preview
@Composable
fun InformationPreview(){
    InformationScreen(navController = rememberNavController(), onBackCLick = ({}))
}