package com.example.kbsc_cooperate.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.kbsc_cooperate.base.Result
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.data.RegionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val regionsRepository: RegionsRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val rooftopName = savedStateHandle.get<String>(KEY_ARG_DETAILS_ROOFTOP_NAME)!!

    val rooftopDetails: Result<ExploreModel>
        get() {
            val region = regionsRepository.getRegion(rooftopName)
            return if (region != null) {
                Result.Success(region)
            } else {
                Result.Error(IllegalArgumentException("존재하지 않는 옥상입니다."))
            }
        }

}