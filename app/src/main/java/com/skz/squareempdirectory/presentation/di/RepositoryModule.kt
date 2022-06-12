package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.data.repository.EmployeeRepositoryImpl
import com.skz.squareempdirectory.data.repository.datasource.EmployeeCacheDataSource
import com.skz.squareempdirectory.data.repository.datasource.EmployeeLocalDataSource
import com.skz.squareempdirectory.data.repository.datasource.EmployeeRemoteDataSource
import com.skz.squareempdirectory.domain.repository.EmployeeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideEmployeeRepository(
        employeeRemoteDataSource: EmployeeRemoteDataSource,
        employeeLocalDataSource: EmployeeLocalDataSource,
        employeeCacheDataSource: EmployeeCacheDataSource
    ):EmployeeRepository{
        return EmployeeRepositoryImpl(employeeRemoteDataSource,employeeLocalDataSource,employeeCacheDataSource)
    }
}