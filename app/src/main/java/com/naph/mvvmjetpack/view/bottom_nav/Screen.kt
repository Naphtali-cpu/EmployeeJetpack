package com.naph.mvvmjetpack.view.bottom_nav

sealed class Screen(
    val route: String
) {
    object EmployeeDetailScreen: Screen("employee_detail_screen")
}