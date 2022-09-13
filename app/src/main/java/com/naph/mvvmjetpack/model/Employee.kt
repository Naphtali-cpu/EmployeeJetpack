package com.naph.mvvmjetpack.model

data class Employee(
    val data: List<Data>,
    val message: String,
    val status: String
)

data class Data(
    val employee_age: Int,
    val employee_name: String,
    val employee_salary: Int,
    val id: String,
    val profile_image: String
)