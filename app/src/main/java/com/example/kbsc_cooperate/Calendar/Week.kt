package com.example.kbsc_cooperate.Calendar

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import java.time.DayOfWeek


@Composable
internal fun DayOfWeek(modifier: Modifier = Modifier) {
    Row(modifier = modifier.clearAndSetSemantics {  }) {
        for (day in DayOfWeek.values()) {

        }

    }
}