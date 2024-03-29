package com.example.kbsc_cooperate.login

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.example.kbsc_cooperate.login.LoginHomeActivity.Companion.TAG

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
            KBSC_CooperateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginHome(auth, onNavToHomePage = { }, onNavToSignUpPage = { })
                }
            }
        }
    }
}

@Composable
fun LoginHome(
    auth: FirebaseAuth,
    ViewModel: ViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToSignUpPage:() -> Unit,
) {
    val context = LocalContext.current
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
        Spacer(modifier = Modifier.size(20.dp))
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
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                    )
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
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                    )
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )

            Button(
                onClick = {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful){
                                Log.d(TAG, "로그인 성공")
                                // 화면 이동시키기 추가
                                onNavToHomePage.invoke()
                            } else {
                                Log.w(TAG, "로그인 실패", it.exception)
                                Toast.makeText(context,
                                    "로그인 실패", Toast.LENGTH_SHORT).show()
                            }
                        }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                enabled = isEmailValid && isPasswordValid
            ) {
                Text(
                    text = "로그인",
                    modifier = Modifier.clickable { onNavToHomePage() },
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
            onClick = {
                if (email.isNullOrBlank() || email.isNullOrEmpty()) {
                    Toast.makeText(context,
                        "이메일을 입력해주세요", Toast.LENGTH_LONG).show()
                }
                else {
                    auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                Log.d(TAG, "이메일 전송 완료")
                                Toast.makeText(
                                    context,
                                    "이메일 전송 완료", Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Log.w(TAG, "이메일 전송 실패", it.exception)
                                Toast.makeText(
                                    context,
                                    "이메일 전송 실패", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
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
            onClick = {
                onNavToSignUpPage.invoke()
            },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "회원가입",
                modifier = Modifier.clickable { onNavToSignUpPage() },
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
    LaunchedEffect(key1 = ViewModel?.hasUser){
        if(ViewModel?.hasUser == true){
            onNavToHomePage.invoke()
        }
    }

}

@Composable
fun SignUpScreen(
    auth: FirebaseAuth,
    ViewModel: ViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToLoginPage:() -> Unit,
) {
    val context = LocalContext.current
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
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "회원가입",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
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
            isError = !isEmailValid,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },

            )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
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
            trailingIcon = {
                IconButton(
                    onClick = { isPasswordVisible = !isPasswordVisible }
                ) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "비밀번호 보이게 전환")
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            isError = !isPasswordValid
        )

        Button(
            onClick = { //회원가입 만들기
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            Log.d(TAG, "회원가입 성공")
                            // 화면 이동시키기 추가
                            onNavToLoginPage.invoke()
                        } else {
                            Log.w(TAG, "회원가입 실패", it.exception)
                            Toast.makeText(context,
                                "회원가입 실패", Toast.LENGTH_SHORT).show()
                        }
                    }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Text(
                text = "회원가입",
                color = Color.Black,
                fontStyle = FontStyle.Italic
            )
        }
        //Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        )
        {
            TextButton(
                onClick = { onNavToLoginPage.invoke() }
            ) {
                Text(
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    text = "로그인하기",
                    modifier = Modifier.clickable { onNavToLoginPage() }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    KBSC_CooperateTheme {
        LoginHome(Firebase.auth, onNavToHomePage = {}, onNavToSignUpPage = { })
    }
}
@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreens() {
    KBSC_CooperateTheme {
        SignUpScreen(Firebase.auth, onNavToHomePage = { /*TODO*/ }) {
        }
    }
}