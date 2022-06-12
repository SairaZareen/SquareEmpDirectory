package com.skz.squareempdirectory.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.skz.squareempdirectory.data.model.Employee

@Database(entities = [Employee::class],version = 1, exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun employeeDao() : EmployeeDAO
}