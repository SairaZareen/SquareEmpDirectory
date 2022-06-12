package com.skz.squareempdirectory.domain.repository

import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.data.model.EmployeeList

interface EmployeeRepository {
    //suspend fun getEmployees():List<Employee>?
    suspend fun getEmployees():List<Employee>?
    //suspend fun updateEmployees():List<Employee>?
    suspend fun updateEmployees():List<Employee>?
}