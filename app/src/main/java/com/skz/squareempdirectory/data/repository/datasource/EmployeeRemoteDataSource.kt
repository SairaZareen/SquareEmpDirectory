package com.skz.squareempdirectory.data.repository.datasource

import com.skz.squareempdirectory.data.model.EmployeeList
import retrofit2.Response

interface EmployeeRemoteDataSource {
    suspend fun getEmployee(): Response<EmployeeList>
    suspend fun getMalformedEmployee():Response<EmployeeList>
    suspend fun getEmptyEmployee():Response<EmployeeList>
}