package com.example.rooftop.buildSrc

object Versions {
    const val ktlint = "0.45.2"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.0"
    const val ktLint = "com.pinterest:ktlint:${Versions.ktlint}"

    const val coreLibraryDesugar = "com.android.tools:desugar_jdk_libs:1.1.5"

    object GoogleMaps {
        const val composeMaps = "com.google.maps.android:maps-compose:2.1.0"
        const val maps = "com.google.android.gms:play-services-maps:18.0.2"
    }

    object Volley {
        const val volley = "com.android.volley:volley:1.2.1"
    }

    object Kotlin {
        private const val version = "1.6.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"

        object Coroutines {
            private const val version = "1.6.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        }

        const val appcompat = "androidx.appcompat:appcompat:1.4.1"

        object Compose {
            const val snapshot = ""
            const val version = "1.2.0-beta02"
            const val version2 = "1.1.1"

            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val materialWindow =
                "androidx.compose.material3:material3-window-size-class:1.0.0-alpha10"

            const val material = "androidx.compose.material:material:$version"
            const val materialIcons = "androidx.compose.material:material-icons-extended:$version2"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"

        }

        object Lifecycle {
            private const val version = "2.4.1"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val navigation = "androidx.navigation:navigation-compose:$version"
        }

        object Test {
            private const val version = "1.4.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
            const val uiAutomator = "androidx.test.uiautomator:uiautomator:2.2.0"
        }

        object Benchmark {
            const val macrobenchmark = "androidx.benchmark:benchmark-macro-junit4:1.1.0-beta04"
        }
    }

    object Hilt {
        private const val version = "2.42"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
    }

    object Coil {
        const val coilCompose = "io.coil-kt:coil-compose:2.0.0"
    }

    object Retrofit2 {

        private const val version = "2.9.0"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Moshi {
        private const val version = "1.9.3"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
    }

    object Kakao {
        private const val version = "2.11.0"

        const val all = "com.kakao.sdk:v2-all:$version" // 전체 모듈 설치, 2.11.0 버전부터 지원
        const val user = "com.kakao.sdk:v2-user:$version" // 카카오 로그인
        const val talk = "com.kakao.sdk:v2-talk:$version" // 친구, 메시지(카카오톡)
        const val story = "com.kakao.sdk:v2-story:$version" // 카카오스토리
        const val share = "com.kakao.sdk:v2-share:$version" // 메시지(카카오톡 공유)
        const val navi = "com.kakao.sdk:v2-navi:$version" // 카카오내비
        const val friend = "com.kakao.sdk:v2-friend:$version" // 카카오톡 소셜 피커, 리소스 번들 파일 포함

    }
}

object Urls {
    const val mavenCentralSnapshotRepo = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val composeSnapshotRepo = "https://androidx.dev/snapshots/builds/" +
            "${Libs.AndroidX.Compose.snapshot}/artifacts/repository/"
}

