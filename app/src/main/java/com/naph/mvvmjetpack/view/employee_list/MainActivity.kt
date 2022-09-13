package com.naph.mvvmjetpack.view.employee_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.ui.theme.MVVMJetpackTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.naph.mvvmjetpack.model.Employee
import com.naph.mvvmjetpack.view.bottom_nav.MainScreen
import retrofit2.Call

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMJetpackTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
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
            "1",
            "https://howtodoandroid.com/images/coco.jpg"
        )
    }
}