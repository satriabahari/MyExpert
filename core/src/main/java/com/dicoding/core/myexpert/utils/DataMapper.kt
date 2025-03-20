package com.dicoding.core.myexpert.utils

import com.dicoding.core.myexpert.data.source.local.entity.MovieEntity
import com.dicoding.core.myexpert.data.source.remote.response.MovieResponse
import com.dicoding.core.myexpert.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> =
        input.map {
            MovieEntity(
                id = it.id ?: 0,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                genreIds = it.genreIds?.joinToString(",") ?: "", // Menyimpan genre sebagai string CSV
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = (it.popularity as? Double) ?: 0.0, // Menangani kemungkinan nilai bukan Double
                voteAverage = (it.voteAverage as? Double) ?: 0.0,
                adult = it.adult,
                voteCount = it.voteCount ?: 0,
                isFavorite = false
            )
        }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                video = it.video,
                title = it.title,
                genreIds = it.genreIds, // Disimpan sebagai string
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                adult = it.adult,
                voteCount = it.voteCount,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        MovieEntity(
            id = input.id,
            overview = input.overview,
            originalLanguage = input.originalLanguage,
            originalTitle = input.originalTitle,
            video = input.video,
            title = input.title,
            genreIds = input.genreIds, // Sudah dalam format string
            posterPath = input.posterPath,
            backdropPath = input.backdropPath,
            releaseDate = input.releaseDate,
            popularity = input.popularity,
            voteAverage = input.voteAverage,
            adult = input.adult,
            voteCount = input.voteCount,
            isFavorite = input.isFavorite
        )
}
