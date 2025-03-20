package com.dicoding.core.myexpert.domain.usecase

import com.dicoding.core.myexpert.domain.model.Movie
import com.dicoding.core.myexpert.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieInteractor @Inject constructor (private val movieRepository: IMovieRepository):
    MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) = movieRepository.setFavoriteMovie(movie, state)
}