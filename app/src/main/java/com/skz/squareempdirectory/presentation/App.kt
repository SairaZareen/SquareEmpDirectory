package com.skz.squareempdirectory.presentation

import android.app.Application
import com.skz.squareempdirectory.BuildConfig
import com.skz.squareempdirectory.presentation.di.*
import com.skz.squareempdirectory.presentation.di.employee.EmployeeSubComponent

class App : Application(),Injector {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .build()
    }

    override fun createEmployeeSubComponent(): EmployeeSubComponent {
        return appComponent.employeeSubComponent().create()
    }

}