package com.naph.mvvmjetpack.view.add_employee

import com.naph.mvvmjetpack.model.AddEmployee
import com.naph.mvvmjetpack.model.Employee
import com.naph.mvvmjetpack.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AddEmployeeRepository @Inject constructor(
    private val createRetrofitInstance: ApiService
) {

    suspend fun addEmployee(newEmployee: AddEmployee): Call<AddEmployee> {
        return createRetrofitInstance.addEmployee(newEmployee)
    }

//    fun createNewEmployee(newEmployee: AddEmployee) {
//        val call: Call<AddEmployee> = createRetrofitInstance.addEmployee(newEmployee)
//        call.enqueue(object : Callback<AddEmployee> {
//            override fun onResponse(call: Call<AddEmployee>, response: Response<AddEmployee>) {
//                createNewEmployeeLiveData.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<AddEmployee>, t: Throwable) {
//                createNewEmployeeLiveData.postValue(null)
//            }
//
//        })
//
//    }
}