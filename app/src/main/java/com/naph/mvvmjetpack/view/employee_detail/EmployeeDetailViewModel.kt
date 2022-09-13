package com.naph.mvvmjetpack.view.employee_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naph.mvvmjetpack.model.AddEmployee
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.model.DataDetail
import com.naph.mvvmjetpack.model.DeleteEmployeeResponse
import com.naph.mvvmjetpack.network.ApiService
import com.naph.mvvmjetpack.network.RetroInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EmployeeDetailViewModel @Inject constructor(
    private val getEmployeeDetailRepo: EmployeeDetailRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var createEmployeeLiveData: MutableLiveData<DeleteEmployeeResponse?> = MutableLiveData()

    private val _employeeState = MutableStateFlow(emptyList<DataDetail>())
    val employeeState: StateFlow<List<DataDetail>>
    get() = _employeeState

    init {
        savedStateHandle.get<String>("id")?.let { id ->
            getSpecificEmployee(id)
        }
    }

    private fun getSpecificEmployee(id: String) {
        viewModelScope.launch {
            val employeeDetails = getEmployeeDetailRepo.getEmployeeDetails(id)
            _employeeState.value = listOf(employeeDetails.data)
        }
    }

    private fun deleteEmployee(id: String) {
        val retroService = RetroInstance.getRetrofitInstance().create(ApiService::class.java)
        val call = retroService.deleteEmployee(id)
        call.message
    }


}