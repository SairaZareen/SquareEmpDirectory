package com.skz.squareempdirectory.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.skz.squareempdirectory.domain.usecase.GetEmployeeUseCase
import com.skz.squareempdirectory.domain.usecase.UpdateEmployeeUseCase

class EmployeeViewModel(private val getEmployeeUseCase: GetEmployeeUseCase,
                        private val updateEmployeeUseCase: UpdateEmployeeUseCase) : ViewModel() {

    fun getEmployees() = liveData {
        val employeeList = getEmployeeUseCase.execute()
        emit(employeeList)
    }

    fun updateEmployees() = liveData {
        val employeeList = updateEmployeeUseCase.execute()
        emit(employeeList)
    }
}