package com.dicoding.core.myexpert.data.source.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "originalLanguage")
    val originalLanguage: String?,

    @ColumnInfo(name = "originalTitle")
    val originalTitle: String?,

    @ColumnInfo(name = "video")
    val video: Boolean?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "genreIds")
    val genreIds: String?, // Stored as JSON or comma-separated values

    @ColumnInfo(name = "posterPath")
    val posterPath: String?,

    @ColumnInfo(name = "backdropPath")
    val backdropPath: String?,

    @ColumnInfo(name = "releaseDate")
    val releaseDate: String?,

    @ColumnInfo(name = "popularity")
    val popularity: Double?,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double?,

    @ColumnInfo(name = "adult")
    val adult: Boolean?,

    @ColumnInfo(name = "voteCount")
    val voteCount: Int?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
