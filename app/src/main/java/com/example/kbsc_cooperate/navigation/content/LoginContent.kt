package com.example.kbsc_cooperate.navigation.content

import android.util.Log
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.login.LoginHome
import com.example.kbsc_cooperate.login.LoginHomeActivity
import com.example.kbsc_cooperate.login.ViewModel
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun LoginContent(
    ViewModel: ViewModel? = null,
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit,
) {
    val loginUiState = ViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_account_circle),
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
                onValueChange = {ViewModel?.onUserNameChange(it)},
                label = { Text("Email") },
                singleLine = true,
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
                },
//                trailingIcon = {
//                    if (email.isNotBlank()) {
//                        IconButton(onClick = { email = "" }) {
//                            Icon(
//                                imageVector = Icons.Filled.Clear,
//                                contentDescription = "이메일 지우기"
//                            )
//
//
//                        }
//                    }
//                }
            )


            OutlinedTextField(
                value = loginUiState?.password ?: "",
                onValueChange = { ViewModel?.onPasswordNameChange(it) },
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
                isError = isError,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
//                trailingIcon = {
//                    IconButton(
//                        onClick = { isPasswordVisible = !isPasswordVisible }
//                    ) {
//                        Icon(
//                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
//                            contentDescription = "비밀번호 보이게 전환"
//                        )
//                    }
//                },
//                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )

            Button(
                onClick = {
//                    auth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener {
//                            if (it.isSuccessful) {
//                                Log.d(LoginHomeActivity.TAG, "로그인 성공")
//                                // 화면 이동시키기 추가
//                                //ViewModel?.loginUser(context)
//                            } else {
//                                Log.w(LoginHomeActivity.TAG, "로그인 실패", it.exception)
//                            }
//                        }
                    ViewModel?.loginUser(context)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                // enabled = isEmailValid && isPasswordValid
            ) {
                Text(
                    text = "로그인",
                    modifier = Modifier.clickable { onClick() },
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    text = "비밀번호 찾기",
                    modifier = Modifier.clickable { onForgotClick() },
                )
            }
        }
        Button(
            onClick = { /* 계정만들기 화면 만들기*/
                onSignUpClick.invoke()
            },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "계정 만들기",
                //modifier = Modifier.clickable { onSignUpClick() },
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginContent() {
//    KBSC_CooperateTheme {
//        LoginContent()
//    }
//}
