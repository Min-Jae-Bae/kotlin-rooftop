package com.example.kbsc_cooperate.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.paging.ExperimentalPagingApi
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@ExperimentalPagingApi
@HiltAndroidTest
class HomeTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun home_navigatesToAllScreens() {

        composeTestRule.setContent {
            KBSC_CooperateTheme {
            }
        }

        composeTestRule.onNodeWithText("예약 목록").assertIsDisplayed()
        composeTestRule.onNodeWithText("ReservationList").performClick()
        composeTestRule.onNodeWithText("검색").assertIsDisplayed()
        composeTestRule.onNodeWithText("Search").performClick()
        composeTestRule.onNodeWithText("좋아요").assertIsDisplayed()
        composeTestRule.onNodeWithText("Like").performClick()
        composeTestRule.onNodeWithText("내 프로필").assertIsDisplayed()
        composeTestRule.onNodeWithText("MyProfile").performClick()

    }
}