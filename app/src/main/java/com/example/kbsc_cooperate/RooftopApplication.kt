package com.example.kbsc_cooperate

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.example.kbsc_cooperate.util.UnsplashSizingInterceptor
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class RooftopApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .components {
                add(UnsplashSizingInterceptor)
            }
            .build()
    }
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this,"44593b77a8f12f5ddd72c19b17ae9745")
    }
}