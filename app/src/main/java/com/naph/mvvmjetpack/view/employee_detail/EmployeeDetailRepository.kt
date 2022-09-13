package com.naph.mvvmjetpack.view.employee_detail

import com.naph.mvvmjetpack.model.DeleteEmployeeResponse
import com.naph.mvvmjetpack.model.EmployeeDetail
import com.naph.mvvmjetpack.network.ApiService
import javax.inject.Inject

class EmployeeDetailRepository @Inject constructor(
    private val getDetailRetroInstance: ApiService
) {
    suspend fun getEmployeeDetails(id: String): EmployeeDetail {
        return getDetailRetroInstance.getEmployeeDetail(id)
    }

    suspend fun deleteSpecificEmployee(id: String): DeleteEmployeeResponse {
        return getDetailRetroInstance.deleteEmployee(id)
    }
}