package com.example.kbsc_cooperate.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kbsc_cooperate.Calendar.model.CalendarState
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.data.RegionsRepository
import com.example.kbsc_cooperate.di.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val regionsRepository: RegionsRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
) : ViewModel(){

    val shownSplash = mutableStateOf(SplashState.Shown)
    val rooftops: List<ExploreModel> = regionsRepository.rooftops
   /*TODO: 캘린더 상태 제작*/

    val calendarState = CalendarState()

    private val _suggestedRegions = MutableLiveData<List<ExploreModel>>()

    val suggestedRegions: LiveData<List<ExploreModel>>
        get() = _suggestedRegions

    init {
        _suggestedRegions.value = regionsRepository.rooftops
    }

    fun onDaySelected(daySelected: LocalDate) {
        viewModelScope.launch {
            calendarState.setSelectedDay(daySelected)
        }
    }


    /*TODO: 검색 기능 제작*/

    /*TODO: 캘린더, 인원수, 날짜 선택, 지역 바꿈 기능 필요*/

}