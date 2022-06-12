package com.skz.squareempdirectory.presentation.di.employee

import com.skz.squareempdirectory.domain.usecase.GetEmployeeUseCase
import com.skz.squareempdirectory.domain.usecase.UpdateEmployeeUseCase
import com.skz.squareempdirectory.presentation.EmployeeViewModelFactory
import com.skz.squareempdirectory.presentation.di.employee.EmployeeScope
import dagger.Module
import dagger.Provides

@Module
class EmployeeModule {
    @EmployeeScope
    @Provides
    fun provideEmployeeViewModelFactory(getEmployeeUseCase: GetEmployeeUseCase,
    updateEmployeeUseCase: UpdateEmployeeUseCase) : EmployeeViewModelFactory{
        return EmployeeViewModelFactory(getEmployeeUseCase,updateEmployeeUseCase)
    }
}