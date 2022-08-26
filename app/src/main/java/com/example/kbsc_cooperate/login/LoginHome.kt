package com.example.kbsc_cooperate.login

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.example.kbsc_cooperate.login.LoginHomeActivity.Companion.TAG
import com.example.kbsc_cooperate.navigation.content.ScreenContent
import com.example.kbsc_cooperate.navigation.graph.AuthScreen
import com.example.kbsc_cooperate.navigation.graph.Graph
import com.example.kbsc_cooperate.navigation.graph.HomeNavGraph

class LoginHomeActivity : ComponentActivity() {
    companion object {
        val TAG : String = LoginHomeActivity::class.java.simpleName
    }

    private val auth by lazy {
        Firebase.auth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            KBSC_CooperateTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    LoginHome(auth)
//                }
//            }
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "Login",
            ){
                composable("Login"){
                    LoginHome(auth, navController)
                }
                composable("SignUp"){
                    GoSignUp(navController)
                }
                composable("Home"){
                    GoHome(navController)
                }
            }
        }
    }
}

@Composable
fun LoginHome(auth: FirebaseAuth, navController: NavController) {
    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isPasswordValid by derivedStateOf {
        password.length > 7
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_myprofile),
            contentDescription = "Account Logo",
            modifier = Modifier.size(150.dp)

        )


        Text(
            text = "로그인 /  회원가입",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp)

        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(all = 10.dp)
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                placeholder = { Text("abc@domain.com") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                isError = !isEmailValid,
                trailingIcon = {
                    if (email.isNotBlank()) {
                        IconButton(onClick = { email = ""}) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "이메일 지우기")


                        }
                    }
                }
            )


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                isError = !isPasswordValid,
                trailingIcon = {
                    IconButton(
                        onClick = { isPasswordVisible = !isPasswordVisible }
                    ) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "비밀번호 보이게 전환")
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )

            Button(
                onClick = {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful){
                                Log.d(TAG, "로그인 성공")
                                // 홈 화면으로 이동시키기 추가
                                navController.navigate("GoHome")
                            } else {
                                Log.w(TAG, "로그인 실패", it.exception)
                            }
                        }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                enabled = isEmailValid && isPasswordValid
            ) {
                Text(
                    text = "로그인",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) { TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                color = Color.Black,
                fontStyle = FontStyle.Italic,
                text = "비밀번호 찾기",
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        }
        Button(
            onClick = { /* 회원가입 화면으로 이동*/
                navController.navigate("GoSignUp")},
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "계정 만들기",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
}

sealed class Routes(val route: String) {
    object Home : Routes("home")
}
@Composable
fun GoHome(navController: NavController) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Graph.HOME) {
            HomeNavGraph(navController)
        }
    }
}

@Composable
fun GoSignUp(navController: NavController) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Graph.HOME) {
            HomeNavGraph(navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    KBSC_CooperateTheme {
        //LoginHome(Firebase.auth)
    }
}
