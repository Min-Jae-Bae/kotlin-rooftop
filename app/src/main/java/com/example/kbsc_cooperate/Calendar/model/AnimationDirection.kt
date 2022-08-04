package com.example.kbsc_cooperate.Calendar.model

enum class AnimationDirection {
    FORWARDS,
    BACKWARDS;

    fun isBackwards() = this == BACKWARDS
    fun isForwards() = this == FORWARDS
}