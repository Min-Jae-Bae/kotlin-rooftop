package com.example.kbsc_cooperate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kbsc_cooperate.data.local.dao.UnsplashImageDao
import com.example.kbsc_cooperate.data.local.dao.UnsplashRemoteKeysDao
import com.example.kbsc_cooperate.model.UnsplashImage
import com.example.kbsc_cooperate.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}