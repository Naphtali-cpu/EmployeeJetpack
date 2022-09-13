package com.naph.mvvmjetpack.view.update_employee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naph.mvvmjetpack.model.AddEmployee
import com.naph.mvvmjetpack.network.ApiService
import com.naph.mvvmjetpack.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateEmployeeViewModel: ViewModel() {
    var updateEmployeeLiveData: MutableLiveData<AddEmployee?> = MutableLiveData()

    fun updateEmployee(id: String, updateEmployee: AddEmployee) {
        val retroService = RetroInstance.getRetrofitInstance().create(ApiService::class.java)
        val call = retroService.updateNewEmployee(id, updateEmployee)
        call.enqueue(object : Callback<AddEmployee> {
            override fun onResponse(call: Call<AddEmployee>, response: Response<AddEmployee>) {
                updateEmployeeLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<AddEmployee>, t: Throwable) {
                updateEmployeeLiveData.postValue(null)
            }

        })
    }
}