package com.example.kbsc_cooperate.data

import androidx.compose.ui.text.intl.Locale
import javax.annotation.concurrent.Immutable

//옥상관련 데이터
@Immutable
data class Rooftop(
    val name: String,
    val region: String,
    val price: String
) {
    val nameToDisplay = "$name, $region"
}




@Immutable
data class ExploreModel(
    val rooftop: Rooftop,
    val description: String,
    val imageUrl: String
)