package com.naph.mvvmjetpack.view.bottom_nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.naph.mvvmjetpack.view.add_employee.AddEmployeeScreen
import com.naph.mvvmjetpack.view.employee_list.EmployeeScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AppBottomNavigation(navController = navController) },
        drawerContent = { Text(text = "Drawer") }
    ) {
        NavHost(navController = navController, startDestination = NAV_HOME) {
            composable(NAV_HOME) {
                EmployeeScreen()
            }

            composable(NAV_ADD_EMPLOYEE) {
                AddEmployeeScreen()
            }

        }
    }

}

