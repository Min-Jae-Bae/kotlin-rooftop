package com.example.kbsc_cooperate

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class RooftopApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "44593b77a8f12f5ddd72c19b17ae9745")
    }
}
