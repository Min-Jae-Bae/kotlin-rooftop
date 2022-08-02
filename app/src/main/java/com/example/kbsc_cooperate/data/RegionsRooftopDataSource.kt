package com.example.kbsc_cooperate.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegionsRooftopDataSource @Inject constructor() {
    val rooftopRooftops = listOf(
        ExploreModel(
            rooftop = MALIN,
            description = "갬성 루프탑",
            imageUrl = "https://images.unsplash.com/photo-1613066697301-d7dccfc86bb5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
        ),
        ExploreModel(
            rooftop = Flower,
            description = "갬성 루프탑",
            imageUrl = "https://images.unsplash.com/photo-1613066697301-d7dccfc86bb5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
        )
    )
}
