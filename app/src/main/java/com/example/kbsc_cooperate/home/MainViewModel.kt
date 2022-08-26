package com.example.kbsc_cooperate.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kbsc_cooperate.calendar.model.CalendarState
import com.example.kbsc_cooperate.navigation.screen.SearchWidgetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
/*    private val regionsRepository: RegionsRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,*/
) : ViewModel(){

/*   val shownSplash = mutableStateOf(SplashState.Shown)
    val rooftops: List<ExploreModel> = regionsRepository.rooftops*/
   //*TODO: 캘린더 상태 제작*//*

    val calendarState = CalendarState()

 /*  private val _suggestedRegions = MutableLiveData<List<ExploreModel>>()

    val suggestedRegions: LiveData<List<ExploreModel>>
        get() = _suggestedRegions

    init {
        _suggestedRegions.value = regionsRepository.rooftops
    }*/

    fun onDaySelected(daySelected: LocalDate) {
        viewModelScope.launch {
            calendarState.setSelectedDay(daySelected)
        }
    }


    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> = mutableStateOf("")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }
}