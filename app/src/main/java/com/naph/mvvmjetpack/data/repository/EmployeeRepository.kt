package com.naph.mvvmjetpack.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.model.Employee
import com.naph.mvvmjetpack.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val retrofitInstance: ApiService
) {

    suspend fun getAllEmployees(): Employee {
        return retrofitInstance.getEmployees()
    }

//    fun getAllEmployees(liveDataList: MutableLiveData<List<Data>>) {
//        val call: Call<Employee> = retrofitInstance.getEmployees()
//        call.enqueue(object : Callback<Employee> {
//            override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
//                liveDataList.postValue(response.body()?.data!!)
//                Log.i("DATASUCC", response.body()?.data.toString())
//            }
//
//            override fun onFailure(call: Call<Employee>, t: Throwable) {
//                liveDataList.postValue(null)
//                Log.i("DATAERR", t.toString())
//            }
//
//        })
//    }
}