package com.skz.squareempdirectory.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.skz.squareempdirectory.data.model.Employee


@Dao
interface EmployeeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEmployee(employee : List<Employee>)

    @Query("DELETE FROM employee_square")
    suspend fun deleteAllEmployees()

    @Query("SELECT * FROM employee_square")
    suspend fun getEmployees() : List<Employee>
}