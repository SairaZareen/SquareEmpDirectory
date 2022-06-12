package com.skz.squareempdirectory.data.api

import com.skz.squareempdirectory.data.model.EmployeeList
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeService {

    @GET("sq-mobile-interview/employees.json")
    suspend fun getEmployeeList():Response<EmployeeList>

    @GET("sq-mobile-interview/employees_malformed.json")
    suspend fun getMalformedEmployeeList():Response<EmployeeList>

    @GET("sq-mobile-interview/employees_empty.json")
    suspend fun getEmptyEmployeeList():Response<EmployeeList>
}