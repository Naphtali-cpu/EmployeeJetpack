package com.naph.mvvmjetpack.view.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naph.mvvmjetpack.view.add_employee.AddEmployeeScreen
import com.naph.mvvmjetpack.view.employee_list.EmployeeScreen

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
//            EmployeeScreen(navController = navController)
        }

        composable(route = Screen.AddEmployeeScreen.route) {
            AddEmployeeScreen(navController = navController)
        }

    }

}

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object AddEmployeeScreen: Screen("add_employee_screen")
}