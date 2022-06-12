package com.skz.squareempdirectory.presentation.di

import com.skz.squareempdirectory.data.api.EmployeeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideEmployeeService(retrofit: Retrofit): EmployeeService{
        return retrofit.create(EmployeeService::class.java)
    }
}