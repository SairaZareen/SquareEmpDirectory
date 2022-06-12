package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.data.repository.datasource.EmployeeCacheDataSource
import com.skz.squareempdirectory.data.repository.datasourceImpl.EmployeeCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideEmployeeCacheDataSource():EmployeeCacheDataSource{
        return EmployeeCacheDataSourceImpl()
    }
}