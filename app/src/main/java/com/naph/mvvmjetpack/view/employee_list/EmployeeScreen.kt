package com.naph.mvvmjetpack.view.employee_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.view.bottom_nav.NAV_EMPLOYEE_DETAIL_SCREEN


@Composable
fun EmployeeScreen(
    navController: NavController
) {
    val employeeViewModel = hiltViewModel<EmployeeViewModel>()
//    val employeeViewModel = viewModel(modelClass = EmployeeViewModel::class.java)
    val state by employeeViewModel.state.collectAsState()
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            if (state.isEmpty()) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }
            }

            items(state) { employee: Data ->
                EmployeeItem(
                    employee = employee
                ) {
//                        Toast.makeText(context, employee.id, Toast.LENGTH_LONG).show()
                    navController.navigate(NAV_EMPLOYEE_DETAIL_SCREEN + "/${employee.id}")
                }
            }
        }
    }

}
