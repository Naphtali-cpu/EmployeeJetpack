package com.naph.mvvmjetpack.network

import com.naph.mvvmjetpack.model.Employee
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("v1/employees")
    suspend fun getEmployees(): Call<Employee>

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://dummy.restapiexample.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)

            }
//            Log.i("STUFF", apiService.toString())
            return apiService!!
        }
    }
}