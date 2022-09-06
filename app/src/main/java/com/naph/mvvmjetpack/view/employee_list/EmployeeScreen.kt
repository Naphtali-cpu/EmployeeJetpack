package com.naph.mvvmjetpack.view.employee_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.naph.mvvmjetpack.model.Data

@Composable
fun EmployeeScreen(
//    navController: NavController
) {
    val employeeViewModel = viewModel(modelClass = EmployeeViewModel::class.java)
    val state by employeeViewModel.state.collectAsState()
    Text(
        text = "Photos",
        style = MaterialTheme.typography.h4
    )
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
            EmployeeItem(employee = employee)
        }
    }
}
