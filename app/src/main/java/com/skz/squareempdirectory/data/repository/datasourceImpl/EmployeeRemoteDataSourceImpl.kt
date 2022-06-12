package com.skz.squareempdirectory.data.repository.datasourceImpl

import com.skz.squareempdirectory.data.api.EmployeeService
import com.skz.squareempdirectory.data.model.EmployeeList
import com.skz.squareempdirectory.data.repository.datasource.EmployeeRemoteDataSource
import retrofit2.Response

class EmployeeRemoteDataSourceImpl(private val employeeService: EmployeeService) : EmployeeRemoteDataSource{
    override suspend fun getEmployee(): Response<EmployeeList> = employeeService.getEmployeeList()
    override suspend fun getMalformedEmployee(): Response<EmployeeList> = employeeService.getMalformedEmployeeList()
    override suspend fun getEmptyEmployee(): Response<EmployeeList> = employeeService.getEmptyEmployeeList()

}