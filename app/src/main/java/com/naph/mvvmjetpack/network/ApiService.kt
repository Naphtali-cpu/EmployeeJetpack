package com.naph.mvvmjetpack.network

import com.naph.mvvmjetpack.model.AddEmployee
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.model.Employee
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    
    @GET("v1/employees")
    suspend fun getEmployees(): Employee

    @POST("v1/create")
    fun addEmployee(
        @Body params: AddEmployee
    ): Call<AddEmployee>

}