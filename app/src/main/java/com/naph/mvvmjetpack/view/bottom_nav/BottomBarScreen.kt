package com.naph.mvvmjetpack.view.bottom_nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.naph.mvvmjetpack.R

sealed class BottomBarScreen(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home : BottomBarScreen(R.string.home, R.drawable.home, NAV_HOME)
    object AddEmployee : BottomBarScreen(R.string.add_employee, R.drawable.add, NAV_ADD_EMPLOYEE)
}
