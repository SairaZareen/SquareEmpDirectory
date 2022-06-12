package com.skz.squareempdirectory.data.repository.datasource

import com.skz.squareempdirectory.data.model.Employee

interface EmployeeCacheDataSource {
    suspend fun getEmployeesFromCache():List<Employee>
    suspend fun saveEmployeesToCache(employees:List<Employee>)
}