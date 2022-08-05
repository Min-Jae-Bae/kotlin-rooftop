package com.example.kbsc_cooperate.Calendar


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.Calendar.model.CalendarState
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.home.MainViewModel
import java.time.LocalDate

@Composable
fun CalendarScreen(
    onBackPressed: () -> Unit,
    mainViewModel: MainViewModel,
) {
    val calendarState = remember {
        mainViewModel.calendarState
    }

    CalendarContent(
        calendarState = calendarState,
        onDayClicked = { dateClicked ->
            mainViewModel.onDaySelected(dateClicked)

        },
        onBackPressed = onBackPressed
    )
}

@Composable
private fun CalendarContent(
    calendarState: CalendarState,
    onDayClicked: (LocalDate) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        modifier = Modifier.windowInsetsPadding(
            WindowInsets.navigationBars.only(WindowInsetsSides.Start + WindowInsetsSides.End)
        ),
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            CalendarTopAppBar(calendarState, onBackPressed)
        }
    ) { contentPadding ->
        Calendar(
            calendarState = calendarState,
            onDayClicked = onDayClicked,
            contentPadding = contentPadding
        )
    }
}

@Composable
private fun CalendarTopAppBar(
    calendarState: CalendarState,
    onBackPressed: () -> Unit,
) {
    val calendarUiState = calendarState.calendarUiState.value
    Column {
        Spacer(
            modifier = Modifier
                .windowInsetsTopHeight(WindowInsets.statusBars)
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant)
        )
        TopAppBar(
            title = {
                Text(
                    text = if (!calendarUiState.hasSelectedDates) {
                        stringResource(id = R.string.달력_선택_날짜_제목)
                    } else {
                        calendarUiState.selectedDatesFormatted
                    }
                )
            },
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.cd_뒤로가기),
                        tint = MaterialTheme.colors.onSurface
                    )
                }
            },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            elevation = 0.dp
        )
    }
}