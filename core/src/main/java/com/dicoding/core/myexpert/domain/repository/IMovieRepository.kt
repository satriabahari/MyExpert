package com.dicoding.core.myexpert.domain.repository

import com.dicoding.core.myexpert.data.Resource
import com.dicoding.core.myexpert.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(tourism: Movie, state: Boolean)
}
