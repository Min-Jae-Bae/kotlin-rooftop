package com.example.kbsc_cooperate.Calendar.model

import java.time.YearMonth

data class Month(
    val YearMonth: YearMonth,
    val weeks: List<Week>,
)