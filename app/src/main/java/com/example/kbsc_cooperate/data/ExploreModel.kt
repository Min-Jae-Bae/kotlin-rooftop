package com.example.kbsc_cooperate.data

import javax.annotation.concurrent.Immutable

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