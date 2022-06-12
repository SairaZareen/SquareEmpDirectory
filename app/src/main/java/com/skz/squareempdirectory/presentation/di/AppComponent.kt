package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.presentation.MainActivity
import com.skz.squareempdirectory.presentation.di.employee.EmployeeModule
import com.skz.squareempdirectory.presentation.di.employee.EmployeeScope
import com.skz.squareempdirectory.presentation.di.employee.EmployeeSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun employeeSubComponent():EmployeeSubComponent.Factory

}