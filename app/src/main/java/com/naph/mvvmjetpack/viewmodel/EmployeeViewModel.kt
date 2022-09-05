package com.naph.mvvmjetpack.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naph.mvvmjetpack.model.Employee
import com.naph.mvvmjetpack.network.ApiService
import kotlinx.coroutines.launch
import java.lang.Exception

class EmployeeViewModel : ViewModel() {

    var employeeListResponse: List<Employee> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getEmployeeList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val employeeList = apiService.getEmployees()
                employeeListResponse = employeeList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.i("ERRSTUFF", e.message.toString())
            }
        }

    }
}



