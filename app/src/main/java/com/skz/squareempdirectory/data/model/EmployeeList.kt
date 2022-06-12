package com.skz.squareempdirectory.data.model


import com.google.gson.annotations.SerializedName

data class EmployeeList(
    @SerializedName("employees")
    val employees: List<Employee>
)