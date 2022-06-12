package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.data.db.EmployeeDAO
import com.skz.squareempdirectory.data.repository.datasource.EmployeeLocalDataSource
import com.skz.squareempdirectory.data.repository.datasourceImpl.EmployeeLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideEmployeeLocalDataSource(employeeDAO: EmployeeDAO):EmployeeLocalDataSource{
        return EmployeeLocalDataSourceImpl(employeeDAO)
    }
}