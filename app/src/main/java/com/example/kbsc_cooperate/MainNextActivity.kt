
package com.example.kbsc_cooperate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KBSC_CooperateTheme {
                // A surface container using the 'background' color from the theme
               MyApp()
            }
        }
    }
}
@Composable
private fun MyApp(){
    Surface(color = MaterialTheme.colors.background) {
        Greeting("Android")

    }
}
@Composable
fun Greeting(name: String) {

    Surface(color = MaterialTheme.colors.background) {


        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
           // verticalArrangement = Arrangement.SpaceAround,
          horizontalAlignment =  Alignment.CenterHorizontally
        )
            {

            Button( //위치
                onClick = { },
                modifier = Modifier
                    .padding(top = 70.dp, bottom = 20.dp)
                    .width(262.dp)
                    .height(43.dp),
                shape = RoundedCornerShape(20.dp),
               // maxLines = if(isExpanded) Int.MAX_VALUE else 1,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onSecondary
                ),
                elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
                //contentPadding = PaddingValues(0.dp),
                //modifier = Modifier.wrapContentSize()
            ) {
               Icon(
                    Icons.Filled.Place,
                   contentDescription = "place",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("위치",
                    fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.background)
            }
            Button( //인원 수
                onClick = { },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .width(262.dp)
                    .height(43.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onSecondary
                ),
                elevation = ButtonDefaults.elevation(defaultElevation = 10.dp)
                //contentPadding = PaddingValues(0.dp),
                //modifier = Modifier.wrapContentSize()
            ) {
                Icon(
                    Icons.Filled.Person,
                   // painter = painterResource(id = R.drawable.baseline_place_24),
                    contentDescription = "person",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("인원 수",
                    color = MaterialTheme.colors.background,
                    fontWeight = FontWeight.Bold
                )
            }
                Button( //날짜
                    onClick = { },
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .width(262.dp)
                        .height(43.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSecondary
                    ),
                    elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
                    //contentPadding = PaddingValues(0.dp),
                    //modifier = Modifier.wrapContentSize()
                ) {
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = "date",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("날짜 선택",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.background)
                }
                Button( //테마 선택
                    onClick = { },
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .width(262.dp)
                        .height(43.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSecondary
                    ),
                    elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
                    //contentPadding = PaddingValues(0.dp),
                    //modifier = Modifier.wrapContentSize()
                ) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "check",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("테마 선택",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.background)
                }
        }
       // Text(text = "Hello $name!", modifier = Modifier.padding(12.dp))
    }

}
@Composable
fun NowPlace(){
   Box(
      modifier = Modifier
          .fillMaxSize(),
       contentAlignment = Alignment.BottomCenter
    ) {
       Box( //선 있는 box
           modifier = Modifier
               .border(1.dp, Color.Black)
               .width(297.dp)
               .height(434.dp),
           contentAlignment = Alignment.Center
       ) {
           Row( // 이미지,장소
               modifier = Modifier.padding(all = 8.dp)
           ) {
               Image(
                   painter = painterResource(R.drawable.image01),
                   contentDescription = "image",
                   modifier = Modifier
                       .size(80.dp)
                       .clip(CircleShape)
                       .border(1.5.dp, Color.Black, CircleShape)
               )
               Spacer(modifier = Modifier.width(13.dp))
               Column(
               ) {
                   Text(text = "서울, 홍대",
                       fontWeight = FontWeight.Bold,
                   modifier = Modifier.padding(vertical = 24.dp))
               }
           }

       }


       }
   }


//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KBSC_CooperateTheme {
        MyApp()
        NowPlace()
    }
}