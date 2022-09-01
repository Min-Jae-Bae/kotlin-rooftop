package com.example.kbsc_cooperate.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.navigation.graph.HomeNavGraph
import com.example.kbsc_cooperate.navigation.screen.BottomBarScreen
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme

@Composable
fun LoginScreen(
    ViewModel: ViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToSignUpPage:() -> Unit,
) {
    val loginUiState = ViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_myprofile),
            contentDescription = "Account Logo",
            modifier = Modifier.size(150.dp)

        )

        Text(
            text = "로그인",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (isError) {
            Text(
                text = loginUiState?.loginError ?: "unknown error",
                color = Color.Red,
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(all = 10.dp)
        ) {
            OutlinedTextField(
                value = loginUiState?.userName ?: "",
                onValueChange = { ViewModel?.onUserNameChange(it) },
                label = { Text(text = "Email") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                isError = isError,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                    )
                }

            )

            OutlinedTextField(
                value = loginUiState?.password ?: "",
                onValueChange = { ViewModel?.onPasswordNameChange(it) },
                label = { Text(text = "Password") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                isError = isError,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                    )
                },

                visualTransformation = PasswordVisualTransformation(),
            )

            Button(
                onClick = {
                    ViewModel?.loginUser(context) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(
                    text = "로그인",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
            //Spacer(modifier = Modifier.size(16.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        )
        {
            TextButton(
                onClick = { onNavToSignUpPage.invoke() }
            ) {
                Text(
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    text = "회원가입"
                )
            }
        }
    }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = ViewModel?.hasUser){
            if(ViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }


    }

@Composable
fun SignUpScreens(
    ViewModel: ViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToLoginPage:() -> Unit,
) {
    val loginUiState = ViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "회원가입",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if(isError){
            Text(
                text = loginUiState?.signUpError ?: "unknown error",
                color = Color.Red,
            )
        }

        OutlinedTextField(
            value = loginUiState?.userNameSignUp ?: "",
            onValueChange = { ViewModel?.onUserNameChangeSignUp(it) },
            label = { Text( "Email") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            isError = isError,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },

            )
        OutlinedTextField(
            value = loginUiState?.passwordSignUp ?: "",
            onValueChange = { ViewModel?.onPasswordChangeSignup(it) },
            label = {
                Text(text = "Password")
            },
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        OutlinedTextField(
            value = loginUiState?.confirmpasswordSignUp ?: "",
            onValueChange = { ViewModel?.onConfirmPasswordChange(it) },
            label = {
                Text(text = "비밀번호 확인")
            },
            modifier = Modifier
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        Button(onClick = {
            ViewModel?.createUser(context) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent)
        ){
            Text(text = "회원가입",
                color = Color.Black,
                fontStyle = FontStyle.Italic )
        }
        //Spacer(modifier = Modifier.size(16.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,)
        {
            TextButton(
                onClick = { onNavToLoginPage.invoke() }
            ) {
                Text(
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    text = "로그인하기"
                )
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = ViewModel?.hasUser){
            if(ViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }


    }
}



@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen() {
    KBSC_CooperateTheme {
        LoginScreen(onNavToHomePage ={}) {

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreen() {
    KBSC_CooperateTheme {
        SignUpScreens(onNavToHomePage = { /*TODO*/ }) {
            
        }
    }
}