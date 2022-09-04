package com.example.kbsc_cooperate.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import com.example.kbsc_cooperate.calendar.model.CalendarState
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.data.RegionsRepository
import com.example.kbsc_cooperate.data.repository.Repository
import com.example.kbsc_cooperate.di.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject


@ExperimentalPagingApi
@HiltViewModel
class MainViewModel @Inject constructor(
    repository: Repository,
    private val regionsRepository: RegionsRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel(){
    val getAllImages = repository.getAllImages()

    val rooftops: List<ExploreModel> = regionsRepository.rooftops
    //*TODO: 캘린더 상태 제작*//*

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



    private val _searchTextState: MutableState<String> = mutableStateOf("")
    val searchTextState: State<String> = _searchTextState


    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }


}