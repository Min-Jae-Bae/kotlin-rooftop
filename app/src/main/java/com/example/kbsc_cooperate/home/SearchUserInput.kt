package com.example.kbsc_cooperate.home

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.base.RoofTopUserInput
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme

enum class PeopleUserInputAnimationState { Valid, Invalid }

class PeopleUserInputState {
    var MAX_PEOPLE = 10
    var people by mutableStateOf(1)
        private set

    val animationState: MutableTransitionState<PeopleUserInputAnimationState> =
        MutableTransitionState(PeopleUserInputAnimationState.Valid)

    fun addPerson() {
        people = (people % (MAX_PEOPLE + 1)) + 1
        updateAnimationState()
    }

    private fun updateAnimationState() {
        val newState =
            if (people > MAX_PEOPLE) PeopleUserInputAnimationState.Invalid
            else PeopleUserInputAnimationState.Valid

        if (animationState.currentState != newState) animationState.targetState = newState
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PeopleUserInput(
    titleSuffix: String = "",
    onPeopleChanged: (Int) -> Unit,
    peopleState: PeopleUserInputState = remember { PeopleUserInputState() }
) {
    Column {
        val transitionState = remember { peopleState.animationState }
        /* val tint = tintPeopleUserInput(transitionState)*/
        val people = peopleState.people
        RoofTopUserInput(
            text = "인원  수",
            vectorImageId = R.drawable.ic_person,
            /* tint = tint.value,*/
            onClick = {
                peopleState.addPerson()
                onPeopleChanged(peopleState.people)
            }
        )
    }
}

@Preview
@Composable
fun PeopleUserInputPreview() {
    KBSC_CooperateTheme() {
        PeopleUserInput(onPeopleChanged = {})
    }
}