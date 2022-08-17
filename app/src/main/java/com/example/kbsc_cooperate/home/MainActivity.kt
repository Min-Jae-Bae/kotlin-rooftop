package com.example.kbsc_cooperate.home

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Size
import androidx.annotation.VisibleForTesting
import androidx.compose.animation.core.*
import androidx.compose.animation.core.Spring.StiffnessLow
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.details.launchDetailsActivity
import com.example.kbsc_cooperate.login.LoginHome
import com.example.kbsc_cooperate.login.LoginHomeActivity
import com.example.kbsc_cooperate.login.LoginViewModel
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Route

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            KBSC_CooperateTheme {
                val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Routes.Login.route) {
                    composable(Routes.Login.route) {
                        val loginViewModel = hiltViewModel<LoginViewModel>()
                        LoginScreen(navController)
                    }

                    composable(Routes.Home.route){
                        val mainViewModel = hiltViewModel<MainViewModel>()
                        MainScreen(
                            widthSize = widthSizeClass,
                            onExploreItemClicked = {
                                launchDetailsActivity(context = this@MainActivity, item = it)
                            },
                            onSearchBarExploreItem = {
                                navController.navigate(Routes.Reservation.route)
                            },
                            mainViewModel = mainViewModel
                        )
                    }
                    composable(Routes.Reservation.route) {
                        val parentEntry = remember {
                            navController.getBackStackEntry(Routes.Home.route)
                        }
                        val parentViewModel = hiltViewModel<MainViewModel>(
                            parentEntry
                        )
                        ReservationScreen()


                    }
                }
            }
        }
    }
}


sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Reservation : Routes("reservation") // 검색화면으로 이동 객체
    object Login : Routes("login")  // 로그인화면으로 이동 객체
}

@Composable
fun LoginScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    /*유효한지 확인*/
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
//                    auth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener {
//                            if (it.isSuccessful){
//                                Log.d(LoginHomeActivity.TAG, "로그인 성공")
//                            } else {
//                                Log.w(LoginHomeActivity.TAG, "로그인 실패", it.exception)
//                            }
//                        }
                          navController.navigate(Routes.Home.route)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
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
            onClick = { },
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
        Button(
            onClick = { /*TODO*/ },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Google Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = "구글 계정으로 로그인",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
        Button(
            onClick = { /*TODO*/ },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_naver),
                contentDescription = "Naver Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)

            )
            Text(
                text = "네이버로 로그인",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
        Button(
            onClick = { /*TODO*/ },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_kakao),
                contentDescription = "Kakao Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)

            )
            Text(
                text = "카카오 계정으로 로그인",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
}


@VisibleForTesting
@Composable
fun MainScreen(
    widthSize: WindowWidthSizeClass,
    onExploreItemClicked: OnExploreItemClicked,
    onSearchBarExploreItem: () -> Unit,
    mainViewModel: MainViewModel,
) {
    Surface(
        modifier = Modifier.windowInsetsPadding(
            WindowInsets.navigationBars.only(WindowInsetsSides.Start + WindowInsetsSides.End)
        ),
        color = MaterialTheme.colors.primary
    ) {
        val transitionState = remember { MutableTransitionState(mainViewModel.shownSplash.value) }
        val transition = updateTransition(transitionState, label = "스플래쉬 반환")
        val splashAlpha by transition.animateFloat(
            transitionSpec = { tween(durationMillis = 100) }, label = "스플래쉬 알파"
        ) {
            if (it == SplashState.Shown) 1f else 0f
        }
        val contentAlpha by transition.animateFloat(
            transitionSpec = { tween(durationMillis = 300) }, label = "내용 알파"
        ) {
            if (it == SplashState.Shown) 0f else 1f
        }
        val contentTopPadding by transition.animateDp(
            transitionSpec = { spring(stiffness = StiffnessLow) }, label = "상단 내용 간격"
        ) {
            if (it == SplashState.Shown) 100.dp else 0.dp
        }

        Box {
            LandingScreen(
                modifier = Modifier.alpha(splashAlpha),
                onTimeout = {
                    transitionState.targetState = SplashState.Completed
                    mainViewModel.shownSplash.value = SplashState.Completed
                }
            )

            MainContent(
                modifier = Modifier.alpha(contentAlpha),
                topPadding = contentTopPadding,
                widthSize = widthSize,
                onExploreItemClicked = onExploreItemClicked,
                onSearchBarExploreItem = onSearchBarExploreItem,
                viewModel = mainViewModel
            )
        }
    }
}


@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
    widthSize: WindowWidthSizeClass,
    onExploreItemClicked: OnExploreItemClicked,
    onSearchBarExploreItem: () -> Unit,
    viewModel: MainViewModel,
) {
    Column(modifier = modifier) {
        Spacer(Modifier.padding(top = topPadding))
        RooftopHome(
            widthSize = widthSize,
            modifier = modifier,
            onExploreItemClicked = onExploreItemClicked,
            viewModel = viewModel
        )
    }
}


enum class SplashState { Shown, Completed }

//@Preview
//@Composable
//fun LoginScreenPreview() {
//    KBSC_CooperateTheme {
//        LoginHome(auth = Firebase.auth)
//    }
//}

