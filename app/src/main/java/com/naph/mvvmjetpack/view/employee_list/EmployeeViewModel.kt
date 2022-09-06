package com.naph.mvvmjetpack.view.employee_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naph.mvvmjetpack.data.repository.EmployeeRepository
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.model.Employee
import com.naph.mvvmjetpack.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val employeeRepo: EmployeeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<Data>())
    val state: StateFlow<List<Data>>
        get() = _state

    init {
        viewModelScope.launch {
            val employees = employeeRepo.getAllEmployees()
            _state.value = employees.data
        }
    }

}



