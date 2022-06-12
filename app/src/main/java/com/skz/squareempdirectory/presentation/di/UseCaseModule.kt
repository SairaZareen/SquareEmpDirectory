package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.domain.repository.EmployeeRepository
import com.skz.squareempdirectory.domain.usecase.GetEmployeeUseCase
import com.skz.squareempdirectory.domain.usecase.UpdateEmployeeUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(employeeRepository: EmployeeRepository):GetEmployeeUseCase{
        return GetEmployeeUseCase(employeeRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(employeeRepository: EmployeeRepository):UpdateEmployeeUseCase{
        return UpdateEmployeeUseCase(employeeRepository)
    }
}