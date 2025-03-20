package com.dicoding.myexpert.di

import com.dicoding.core.myexpert.domain.usecase.MovieInteractor
import com.dicoding.core.myexpert.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideMovieUseCase(tourismInteractor: MovieInteractor): MovieUseCase

}
