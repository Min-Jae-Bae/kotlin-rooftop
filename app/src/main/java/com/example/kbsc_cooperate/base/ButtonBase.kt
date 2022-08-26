package com.example.kbsc_cooperate.base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


val IconButtonSizeModifier = Modifier.size(30.dp)

@Composable
fun RoundIconButtons(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit,
    tint: Color = MaterialTheme.colors.onSecondary,
    backgroundColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp,
) {
    Card(modifier = modifier
        .padding(all = 4.dp)
        .clickable {
            onClick.invoke()
        }
        .then(IconButtonSizeModifier),
        shape = CircleShape,
        backgroundColor = backgroundColor,
        elevation = elevation) {
        Icon(imageVector, contentDescription = "Plus or Minus icon", tint = tint)
    }
}


