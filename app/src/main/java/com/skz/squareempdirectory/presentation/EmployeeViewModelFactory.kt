package com.skz.squareempdirectory.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.skz.squareempdirectory.domain.usecase.GetEmployeeUseCase
import com.skz.squareempdirectory.domain.usecase.UpdateEmployeeUseCase

class EmployeeViewModelFactory(
    private val getEmployeeUseCase: GetEmployeeUseCase,
    private val updateEmployeeUseCase: UpdateEmployeeUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeViewModel(getEmployeeUseCase,updateEmployeeUseCase) as T
    }

}