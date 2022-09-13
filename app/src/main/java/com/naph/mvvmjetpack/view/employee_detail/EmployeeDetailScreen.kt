package com.naph.mvvmjetpack.view.employee_detail

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.view.update_employee.UpdateEmployeeScreen

@Composable
fun EmployeeDetailScreen(
    viewModel: EmployeeDetailViewModel = hiltViewModel(),
    id: String,
//    onItemClick: (Data) -> Unit,
//    employeeId: Data
) {
    val state = viewModel.employeeState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {
        items(state.value) {
            Text(
                text = state.value[0].employee_name,
                style = MaterialTheme.typography.h3
            )
        }
    }

    Button(onClick = {

    },
        Modifier.clickable {  }) {
        Text(text = "Delete Employee")
    }

    UpdateEmployeeScreen(id)
}