package com.example.kbsc_cooperate.Calendar

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.Calendar.model.CalendarState
import com.example.kbsc_cooperate.Calendar.model.CalendarUiState
import com.example.kbsc_cooperate.Calendar.model.Month
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import com.example.kbsc_cooperate.util.EaseOutQuart
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.time.temporal.WeekFields


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Calendar(
    calendarState: CalendarState,
    onDayClicked: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
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
            itemCalendarMonth(
                calendarUiState,
                onDayClicked,
                { selectedAnimationPercentage.value },
                month
            )
        }

        item(key = "바닥 간격") {
            Spacer(
                modifier = Modifier.windowInsetsBottomHeight(
                    WindowInsets.navigationBars
                )
            )
        }
    }
}

private fun LazyListScope.itemCalendarMonth(
    calendarUiState: CalendarUiState,
    onDayClicked: (date: LocalDate) -> Unit,
    selectedPercentageProvider: () -> Float,
    month: Month,
) {
    item(month.YearMonth.month.name + month.YearMonth.year + "앞 부분") {
        MonthHeader(
            modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 30.dp),
            month = month.YearMonth.month.name,
            year = month.YearMonth.year.toString()
        )
    }

    val contentModifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
    item(month.YearMonth.month.name + month.YearMonth.year + "요일") {
        DaysOfWeek(modifier = contentModifier)
    }

    itemsIndexed(month.weeks, key = { index, _ ->
        month.YearMonth.year.toString() + "/" + month.YearMonth.month.value + "/" + (index + 1).toString()
    }) { _, week ->
        val beginningWeek = week.yearMonth.atDay(1).plusWeeks(week.number.toLong())
        val currentDay = beginningWeek.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

        if (calendarUiState.hasSelectedPeriodOverlap(currentDay, currentDay.plusDays(6))) {
            WeekSelectionPill(
                week = week,
                currentWeekStart = currentDay,
                state = calendarUiState,
                selectedPercentageTotalProvider = selectedPercentageProvider
            )
        }
        Week(
            calendarUiState = calendarUiState,
            modifier = contentModifier,
            week = week,
            onDayClicked = onDayClicked
        )
        Spacer(modifier = Modifier.height(6.dp))
    }
}


internal val CALENDAR_STARTS_ON = WeekFields.ISO

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    KBSC_CooperateTheme {
        Calendar(CalendarState(), onDayClicked = { })
    }
}