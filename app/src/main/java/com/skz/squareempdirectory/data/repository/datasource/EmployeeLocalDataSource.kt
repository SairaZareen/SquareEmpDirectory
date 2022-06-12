package com.skz.squareempdirectory.data.repository.datasource

import com.skz.squareempdirectory.data.model.Employee

interface EmployeeLocalDataSource {
    suspend fun getEmployeesFromDB():List<Employee>
    suspend fun saveEmployeesToDB(employees:List<Employee>)
    suspend fun clearAll()
}