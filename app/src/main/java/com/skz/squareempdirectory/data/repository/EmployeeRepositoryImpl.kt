package com.skz.squareempdirectory.data.repository

import android.util.Log
import android.widget.Toast
import com.skz.squareempdirectory.data.model.Employee
import com.skz.squareempdirectory.data.repository.datasource.EmployeeCacheDataSource
import com.skz.squareempdirectory.data.repository.datasource.EmployeeLocalDataSource
import com.skz.squareempdirectory.data.repository.datasource.EmployeeRemoteDataSource
import com.skz.squareempdirectory.domain.repository.EmployeeRepository
import com.skz.squareempdirectory.presentation.MainActivity
import java.io.IOException

class EmployeeRepositoryImpl(
    private val employeeRemoteDataSource: EmployeeRemoteDataSource,
    private val employeeLocalDataSource: EmployeeLocalDataSource,
    private val employeeCacheDataSource: EmployeeCacheDataSource
) : EmployeeRepository{


    override suspend fun getEmployees(): List<Employee> {
        return getEmployeesFromCache()
    }

    override suspend fun updateEmployees(): List<Employee> {
        val newListOfEmployees = getEmployeesFromAPI()
        employeeLocalDataSource.clearAll()
        employeeLocalDataSource.saveEmployeesToDB(newListOfEmployees)
        employeeCacheDataSource.saveEmployeesToCache(newListOfEmployees)
        return newListOfEmployees
    }

    suspend fun getEmployeesFromAPI():List<Employee>{

          lateinit var employeeList:List<Employee>

            val response = employeeRemoteDataSource.getEmployee()
        if (response.code() == 200){
            val body = response.body()
            if (body!=null){
                employeeList = body.employees
            }
            return employeeList
        }else{
            try {
                Log.v("Tag", "Error" + response.errorBody()!!.string())

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return employeeList
    }

    suspend fun getEmployeesFromDB():List<Employee>{
        lateinit var employeeList:List<Employee>
        try {
            employeeList = employeeLocalDataSource.getEmployeesFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (employeeList.size>0){
            return employeeList
        }else{
            employeeList = getEmployeesFromAPI()
            employeeLocalDataSource.saveEmployeesToDB(employeeList)
        }
        return employeeList
    }

    suspend fun getEmployeesFromCache():List<Employee>{
        lateinit var employeeList:List<Employee>
        try {
            employeeList = employeeCacheDataSource.getEmployeesFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (employeeList.size>0){
            return employeeList
        }else{
            employeeList = getEmployeesFromAPI()
            employeeCacheDataSource.saveEmployeesToCache(employeeList)
        }
        return employeeList
    }
}