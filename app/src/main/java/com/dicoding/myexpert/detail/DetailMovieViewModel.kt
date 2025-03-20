package com.dicoding.myexpert.detail

import androidx.lifecycle.ViewModel
import com.dicoding.core.myexpert.domain.model.Movie
import com.dicoding.core.myexpert.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(private val tourismUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(tourism: Movie, newStatus:Boolean) =
        tourismUseCase.setFavoriteMovie(tourism, newStatus)
}

