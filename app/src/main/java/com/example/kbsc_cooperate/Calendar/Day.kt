package com.example.kbsc_cooperate.Calendar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import java.lang.reflect.Modifier

@Composable
internal fun DayOfWeekHeading(day: String) {


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DayContainer(
    selected: Boolean = false,
    onClick: () -> Unit = { },
    onClickEnabled: Boolean = true,
    backgrounColor: Color = Color.Transparent,
    onClickLabel: String? = null,
    content: @Composable () -> Unit,
) {

}