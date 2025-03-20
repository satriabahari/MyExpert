package com.dicoding.core.myexpert.domain.usecase

import com.dicoding.core.myexpert.data.Resource
import com.dicoding.core.myexpert.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(tourism: Movie, state: Boolean)
}