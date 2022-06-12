package com.skz.squareempdirectory.data.repository.datasourceImpl

import com.skz.squareempdirectory.data.db.EmployeeDAO
import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.data.repository.datasource.EmployeeLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeLocalDataSourceImpl(private val employeeDAO : EmployeeDAO) : EmployeeLocalDataSource {
    override suspend fun getEmployeesFromDB(): List<Employee> {
        return employeeDAO.getEmployees()
    }

    override suspend fun saveEmployeesToDB(employees: List<Employee>) {
        CoroutineScope(Dispatchers.IO).launch {
            employeeDAO.saveEmployee(employees)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            employeeDAO.deleteAllEmployees()
        }
    }
}