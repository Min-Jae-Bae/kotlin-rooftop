package com.example.kbsc_cooperate.login

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme

@Composable
fun LoginScreen(
    ViewModel: ViewModel? = null,
    onNavToHomePate:() -> Unit,
    onNavToSignUpPage:() -> Unit,
) {
    val loginUiState = ViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Login",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.primary
        )

        if(isError){
            Text(
                text = loginUiState?.loginError ?: "unknown error",
                color = Color.Red,
            )
        }

        OutlinedTextField(
            value = loginUiState?.userName ?: "",
            onValueChange = { ViewModel?.onUserNameChange(it) },
            label = { Text(text="Email") },
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            isError = isError
        )
        OutlinedTextField(
            value = loginUiState?.password ?: "",
            onValueChange = { ViewModel?.onPasswordNameChange(it) },
            label = {
                Text(text = "Password")
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        Button(onClick = { ViewModel?.loginUser(context) }) {
            Text(text = "회원가입")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,)
        {
            Text(text = "계정 만들기")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {onNavToSignUpPage.invoke()}){
                Text(text = "회원가입")
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }
        
        LaunchedEffect(key1 = ViewModel?.hasUser){
            if(ViewModel?.hasUser == true){
                onNavToHomePate.invoke()
            }
        }


        }
    }

@Composable
fun SignUpScreen(
    ViewModel: ViewModel? = null,
    onNavToHomePate:() -> Unit,
    onNavToLoginPage:() -> Unit,
) {
    val loginUiState = ViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Sign up",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.primary
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
                .fillMaxSize()
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
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
                .fillMaxSize()
                .padding(16.dp),

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
                .fillMaxSize()
                .padding(16.dp),

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        Button(onClick = { ViewModel?.createUser(context) }) {
            Text(text = "회원가입")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,)
        {
            Text(text = "계정 찾기")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {onNavToLoginPage.invoke()}){
                Text(text = "로그인하기")
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = ViewModel?.hasUser){
            if(ViewModel?.hasUser == true){
                onNavToHomePate.invoke()
            }
        }


    }
}



@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen() {
    KBSC_CooperateTheme {
        LoginScreen(onNavToHomePate = { /*TODO*/ }) {

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreen() {
    KBSC_CooperateTheme {
        SignUpScreen(onNavToHomePate = { /*TODO*/ }) {
            
        }
    }
}