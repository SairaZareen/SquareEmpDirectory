package com.skz.squareempdirectory.data.repository.datasourceImpl

import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.data.repository.datasource.EmployeeCacheDataSource

class EmployeeCacheDataSourceImpl : EmployeeCacheDataSource {
    private var employeeList = ArrayList<Employee>()

    override suspend fun getEmployeesFromCache(): List<Employee> {
        return employeeList
    }

    override suspend fun saveEmployeesToCache(employees: List<Employee>) {
        employeeList.clear()
        employeeList = ArrayList(employees)
    }
}