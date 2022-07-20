package com.example.kbsc_cooperate.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.data.RegionsRepository
import com.example.kbsc_cooperate.di.DefaultDispatcher
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltAndroidApp
class MainViewModel @Inject constructor(

    private val regionsRepository: RegionsRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,

) : ViewModel() {

    val shownSplash = mutableStateOf(SplashState.Shown)
    val rooftops: List<ExploreModel> = regionsRepository.rooftops

    /*TODO: 캘린더 상태 만들기*/

    private val _suggestedRegions = MutableLiveData<List<ExploreModel>>()

    val suggestedRegions: LiveData<List<ExploreModel>>
        get() = _suggestedRegions

    init {
        _suggestedRegions.value = regionsRepository.rooftops
    }

    /*TODO: 캘린더 관련 날짜 선택*/

    /*TODO: 목적지를 검색하는 함수 기능 만들기*/

}