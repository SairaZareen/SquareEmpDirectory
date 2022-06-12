package com.skz.squareempdirectory.presentation.di

import android.content.Context
import androidx.room.Room
import com.skz.squareempdirectory.data.db.EmployeeDAO
import com.skz.squareempdirectory.data.db.EmployeeDatabase
import com.skz.squareempdirectory.data.model.Employee
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideEmployeeDataBase(context : Context): EmployeeDatabase{
        return Room.databaseBuilder(context,EmployeeDatabase::class.java,"employee")
            .build()
    }

    @Singleton
    @Provides
    fun provideEmployeeDao(employeeDatabase: EmployeeDatabase):EmployeeDAO{
        return employeeDatabase.employeeDao()
    }
}