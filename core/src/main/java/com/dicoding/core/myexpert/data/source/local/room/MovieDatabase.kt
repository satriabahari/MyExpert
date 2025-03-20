package com.dicoding.core.myexpert.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.core.myexpert.data.source.local.entity.MovieEntity
import com.dicoding.core.myexpert.data.source.local.room.MovieDao

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}