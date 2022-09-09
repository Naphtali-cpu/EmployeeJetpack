package com.naph.mvvmjetpack.view.add_employee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naph.mvvmjetpack.model.AddEmployee
import com.naph.mvvmjetpack.network.ApiService
import com.naph.mvvmjetpack.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddEmployeeViewModel: ViewModel() {
    lateinit var createEmployeeLiveData: MutableLiveData<AddEmployee?>

    init {
        createEmployeeLiveData = MutableLiveData()
    }

    fun createEmployee(addEmployee: AddEmployee) {
        val retroService = RetroInstance.getRetrofitInstance().create(ApiService::class.java)
        val call = retroService.addEmployee(addEmployee)
        call.enqueue(object : Callback<AddEmployee> {
            override fun onResponse(call: Call<AddEmployee>, response: Response<AddEmployee>) {
                createEmployeeLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<AddEmployee>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}