package com.example.kbsc_cooperate.base

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme


/*TODO HomeFeatures버튼 생성 시 필요*/
/*@Composable
fun SimpleUserInput(
    text: String? = null,
    caption: String? = null,
    @DrawableRes vectorImageId: Int? = null
) {
    CraneUserInput(
        caption = if (text == null) caption else null,
        text = text ?: "",
        vectorImageId = vectorImageId
    )
}*/

@Composable
fun RoofTopUserInput(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    caption: String? = null,
    @DrawableRes vectorImageId: Int? = null,
    tint: Color = LocalContentColor.current
) {
    RoofTopBaseUseInput(
        modifier = modifier,
        onClick = onClick,
        caption = caption,
        vectorImageId = vectorImageId,
        tintIcon = { text.isNotEmpty() },
        tint = tint
    ) {
        Text(maxLines =1,
            text = text,
            style = MaterialTheme.typography.body1.copy(color = tint),
            color = Color.White,
            textAlign = TextAlign.Center)
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun RoofTopBaseUseInput(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    caption: String? = null,
    @DrawableRes vectorImageId: Int? = null,
    showCaption: () -> Boolean = { true },
    tintIcon: () -> Boolean,
    tint: Color = LocalContentColor.current,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier,
        onClick = onClick,
        /*color = MaterialTheme.colors.onSecondary*/
    ) {
        Card(
            modifier = Modifier
                .padding(all = 10.dp)
                .background(color = Color.White),
            border = BorderStroke(color = Color.White, width = Dp.Hairline),
            shape = RoundedCornerShape(15.dp),
        ) {
            Row(
                Modifier
                    .background(MaterialTheme.colors.onSecondary),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Spacer(Modifier.width(130.dp))
                if (vectorImageId != null) {
                    Icon(
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .size(26.dp, 26.dp),
                        painter = painterResource(id = vectorImageId),
                        tint = Color.White,
                        contentDescription = null
                    )
                    Spacer(Modifier.width(8.dp))
                }
                /*if (caption != null && showCaption()) {
                Text(
                    modifier = Modifier
                        .width(120.dp)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    text = ""
                )
                Spacer(Modifier.width(8.dp))
            }*/
                Row(
                    Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically )
                ) {
                    content()
                }
            }
        }
    }
}

val IconButtonSizeModifier = Modifier.size(30.dp)
@Composable
fun RoundIconButtons(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit,
    tint: Color = MaterialTheme.colors.onSecondary,
    backgroundColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp, ){
    Card(modifier = modifier.padding(all=4.dp).clickable{
        onClick.invoke()}.then(IconButtonSizeModifier),
        shape = CircleShape,
        backgroundColor = backgroundColor,
        elevation = elevation){
            Icon(imageVector, contentDescription = "Plus or Minus icon", tint = tint)
    }

}

@Preview
@Composable
fun PreviewInput() {
    KBSC_CooperateTheme() {
        Surface {
            RoofTopBaseUseInput(
                tintIcon = { true },
                vectorImageId = R.drawable.ic_plane,
                caption = "Caption",
                showCaption = { true }
            ) {
                Text(text = "text",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,)
            }
        }
    }
}

