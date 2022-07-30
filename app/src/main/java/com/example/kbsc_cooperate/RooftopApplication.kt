package com.example.kbsc_cooperate

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.example.kbsc_cooperate.util.UnsplashSizingInterceptor
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
}