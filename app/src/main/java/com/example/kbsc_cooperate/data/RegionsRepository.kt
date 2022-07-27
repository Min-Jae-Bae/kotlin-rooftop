package com.example.kbsc_cooperate.data

import javax.inject.Inject
//지역 데이터 source
class RegionsRepository @Inject constructor(
    private val regionsRooftopDataSource: RegionsRooftopDataSource
) {
    // 루프탑 안에 있는 지역 ,이름 , 가격 정보

    val rooftops: List<ExploreModel> = regionsRooftopDataSource.rooftopRooftops

    fun getRegion(rooftopName: String): ExploreModel? {
        return regionsRooftopDataSource.rooftopRooftops.firstOrNull {
            it.rooftop.name == rooftopName
        }
    }
}