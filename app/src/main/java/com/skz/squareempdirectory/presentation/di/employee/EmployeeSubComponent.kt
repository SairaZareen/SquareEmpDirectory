package com.skz.squareempdirectory.presentation.di.employee

import com.skz.squareempdirectory.presentation.MainActivity
import dagger.Subcomponent

@EmployeeScope
@Subcomponent(modules = [EmployeeModule::class])
interface EmployeeSubComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():EmployeeSubComponent
    }
}