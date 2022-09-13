package com.naph.mvvmjetpack.network

import com.naph.mvvmjetpack.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {
    
    @GET("v1/employees")
    suspend fun getEmployees(): Employee

    @GET("v1/employee/{id}")
    suspend fun getEmployeeDetail(
        @Path("id") id: String
    ): EmployeeDetail

    @POST("v1/create")
    fun addEmployee(
        @Body params: AddEmployee
    ): Call<AddEmployee>

    @PUT("v1/update/{id}")
    fun updateNewEmployee(
        @Path("id") id: String,
        @Body params: AddEmployee
    ): Call<AddEmployee>

    @DELETE("v1/delete/{id}")
    fun deleteEmployee(
        @Path("id") id: String
    ): DeleteEmployeeResponse

}