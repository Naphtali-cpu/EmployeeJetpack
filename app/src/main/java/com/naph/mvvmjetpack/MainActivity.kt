package com.naph.mvvmjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.naph.mvvmjetpack.ui.theme.MVVMJetpackTheme
import com.naph.mvvmjetpack.view.employee_list.EmployeeItem
import com.naph.mvvmjetpack.viewmodel.EmployeeViewModel

class MainActivity : ComponentActivity() {

    val employeeViewModel by viewModels<EmployeeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    EmployeeList(employeeList = employeeViewModel.employeeListResponse)
                    employeeViewModel.getEmployeeList()
                }
            }
        }
    }
}

@Composable
fun EmployeeList(employeeList: List<Data>) {
    LazyColumn {
        itemsIndexed(items = employeeList) { index, item ->  
            EmployeeItem(employee = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVMJetpackTheme {
        val employee = Data(
            25,
            "Naphtali Makori",
            130000,
            1,
            "https://howtodoandroid.com/images/coco.jpg"
        )
        EmployeeItem(employee = employee)
    }
}