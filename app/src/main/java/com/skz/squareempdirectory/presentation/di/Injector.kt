package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.presentation.di.employee.EmployeeSubComponent

interface Injector {
    fun createEmployeeSubComponent():EmployeeSubComponent
}