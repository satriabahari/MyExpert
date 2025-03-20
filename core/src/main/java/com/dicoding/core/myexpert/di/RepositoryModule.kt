package com.dicoding.core.myexpert.di

import com.dicoding.core.myexpert.data.MovieRepository
import com.dicoding.core.myexpert.data.source.local.LocalDataSource
import com.dicoding.core.myexpert.data.source.remote.RemoteDataSource
import com.dicoding.core.myexpert.domain.repository.IMovieRepository
import com.dicoding.core.myexpert.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        remote: RemoteDataSource,
        local: LocalDataSource,
        executors: AppExecutors
    ): IMovieRepository =
        MovieRepository(remote, local, executors)

}