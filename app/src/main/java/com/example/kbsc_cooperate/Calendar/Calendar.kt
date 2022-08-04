package com.example.kbsc_cooperate.Calendar

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.kbsc_cooperate.Calendar.model.CalendarState
import com.example.kbsc_cooperate.Calendar.model.CalendarUiState
import com.example.kbsc_cooperate.Calendar.model.Month
import com.example.kbsc_cooperate.util.EaseOutQuart
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Calendar(
    calendarState: CalendarState,
    onDayClicked: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues()
) {
    val calendarUiState = calendarState.calendarUiState.value
    val numberSelectedDays = calendarUiState.numberSelectedDays.toInt()

    val selectedAnimationPercentage = remember(numberSelectedDays) {
        Animatable(0f)
    }

    LaunchedEffect(numberSelectedDays) {
        if (calendarUiState.hasSelectedDates) {

            val animationSpec: TweenSpec<Float> = tween(
                durationMillis =
                (numberSelectedDays.coerceAtLeast(0) * DURATION_MILLIS_PER_DAY)
                    .coerceAtMost(2000),
                easing = EaseOutQuart
            )
            selectedAnimationPercentage.animateTo(
                targetValue = 1f,
                animationSpec = animationSpec
            )
        }
    }

    LazyColumn(
        modifier = modifier.consumedWindowInsets(contentPadding),
        contentPadding = contentPadding
    ) {
        calendarState.listMonths.forEach { month ->
        }
    }
}

private fun LazyListScope.itemCalendarMonth(
    calendarUiState: CalendarUiState,
    onDayClicked: (date: LocalDate) -> Unit,
    selectedPercentageProvider: () -> Float,
    month: Month,
) {
    item(month.YearMonth.month.name + month.YearMonth.year + "header") {
    }
}


internal val CALENDAR_STARTS_ON = WeekFields.ISO