package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.data.api.EmployeeService
import com.skz.squareempdirectory.data.repository.datasource.EmployeeRemoteDataSource
import com.skz.squareempdirectory.data.repository.datasourceImpl.EmployeeRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideEmployeeRemoteDataSource(employeeService: EmployeeService):EmployeeRemoteDataSource{
        return EmployeeRemoteDataSourceImpl(employeeService)
    }
}