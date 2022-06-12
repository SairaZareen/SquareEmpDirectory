package com.skz.squareempdirectory.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "employee_square")
data class Employee(
    @SerializedName("biography")
    val biography: String,
    @SerializedName("email_address")
    val emailAddress: String,
    @SerializedName("employee_type")
    val employeeType: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("photo_url_large")
    val photoUrlLarge: String,
    @SerializedName("photo_url_small")
    val photoUrlSmall: String,
    @SerializedName("team")
    val team: String,
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String
)