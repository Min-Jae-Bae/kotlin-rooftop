package com.example.kbsc_cooperate.Calendar

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.Calendar.model.CalendarUiState
import com.example.kbsc_cooperate.Calendar.model.Week
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters


@Composable
internal fun DaysOfWeek(modifier: Modifier = Modifier) {
    Row(modifier = modifier.clearAndSetSemantics { }) {
        for (day in DayOfWeek.values()) {
            DayOfWeekHeading(day = day.name.take(1))
        }
    }
}

@Composable
internal fun Week(
    calendarUiState: CalendarUiState,
    week: Week,
    onDayClicked: (LocalDate) -> Unit,
    modifier: Modifier = Modifier,
) {
    val beginningWeek = week.yearMonth.atDay(1).plusWeeks(week.number.toLong())
    var currentDay = beginningWeek.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

    Box {
        Row(modifier = modifier) {
            Spacer(
                Modifier
                    .weight(1f)
                    .heightIn(max = CELL_SIZE)
            )
            for (i in 0..6) {
                if (currentDay.month == week.yearMonth.month) {
                    Day(
                        day = currentDay,
                        calendarState = calendarUiState,
                        onDayClicked = onDayClicked,
                        month = week.yearMonth
                    )
                } else {
                    Box(modifier = Modifier.size(CELL_SIZE))
                }
                currentDay = currentDay.plusDays(1)
            }
            Spacer(
                Modifier
                    .weight(1f)
                    .heightIn(max = CELL_SIZE)
            )
        }
    }
}


internal val CELL_SIZE = 46.dp