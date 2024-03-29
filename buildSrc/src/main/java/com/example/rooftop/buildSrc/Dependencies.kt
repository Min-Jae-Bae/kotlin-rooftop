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

    object Firebase {
        const val commonFirebase = "com.google.firebase:firebase-common-ktx:20.1.1"
        const val authFirebase = "com.google.firebase:firebase-auth-ktx:21.0.7"
        const val analyticsFirebase = "com.google.firebase:firebase-analytics-ktx"
    }

    object Volley {
        const val volley = "com.android.volley:volley:1.2.1"
    }

    object Kotlin {
        private const val version = "1.6.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:$version"

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

            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val materialWindow =
                "androidx.compose.material3:material3-window-size-class:1.0.0-alpha10"

            const val material = "androidx.compose.material:material:$version"
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
        const val hilt = "androidx.hilt:hilt-compiler:1.0.0"
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
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val serialConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"

    }

    object Serialization {
        private const val version = "1.3.0"
        const val serialJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
    }

    object Room {
        private const val version = "2.4.0"

        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val paging = "androidx.room:room-paging:$version"
    }

    object Paging {
        private const val version = "1.0.0-alpha14"

        const val compose = "androidx.paging:paging-compose:$version"
    }

    object Moshi {
        private const val version = "1.9.3"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
    }
}

object Urls {
    const val mavenCentralSnapshotRepo = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val composeSnapshotRepo = "https://androidx.dev/snapshots/builds/" +
            "${Libs.AndroidX.Compose.snapshot}/artifacts/repository/"
}

