package com.naph.mvvmjetpack.view.employee_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EmployeeDetailScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "EmployeeDetailScreen")
    }
}

@Preview(name = "EmployeeDetailScreen")
@Composable
private fun PreviewEmployeeDetailScreen() {
    EmployeeDetailScreen()
}