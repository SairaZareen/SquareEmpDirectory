package com.skz.squareempdirectory.domain.usecase

import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.domain.repository.EmployeeRepository

class UpdateEmployeeUseCase(private val employeeRepository: EmployeeRepository) {
    suspend fun execute():List<Employee>? = employeeRepository.updateEmployees()
}