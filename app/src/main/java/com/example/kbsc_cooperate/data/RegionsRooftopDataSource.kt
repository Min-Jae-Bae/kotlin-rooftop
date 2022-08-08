package com.example.kbsc_cooperate.data

import javax.inject.Inject
import javax.inject.Singleton

private const val DEFAULT_IMAGE_WIDTH = "250"

@Singleton
class RegionsRooftopDataSource @Inject constructor() {
    val rooftopRooftops = listOf(
        ExploreModel(
            rooftop = MALIN,
            description = "갬성 루프탑",
            imageUrl = "https://images.unsplash.com/photo-1613066697301-d7dccfc86bb5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
        ),
        ExploreModel(
            rooftop = FLOWER,
            description = "정원 루프탑",
            imageUrl = "https://images.unsplash.com/photo-1568551931477-1191cd1b4a1e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80"
        ),
        ExploreModel(
            rooftop = BAR,
            description = "루프탑 바",
            imageUrl = "https://images.unsplash.com/photo-1621275471769-e6aa344546d5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1173&q=80"
        ),
        ExploreModel(
            rooftop = REST,
            description = "휴식 루프탑",
            imageUrl = "https://images.unsplash.com/photo-1613066697301-d7dccfc86bb5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
        ),
        ExploreModel(
            rooftop = FLEA,
            description = "플리마켓 루프탑",
            imageUrl = "https://images.unsplash.com/photo-1543812226-32a17800526b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1025&q=80"
        ),
        ExploreModel(
            rooftop = POOL,
            description = "수영장 루프탑",
            imageUrl = "https://images.unsplash.com/photo-1613066697301-d7dccfc86bb5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
        )
    )
}
