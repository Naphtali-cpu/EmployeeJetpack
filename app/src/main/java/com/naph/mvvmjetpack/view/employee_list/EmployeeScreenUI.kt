package com.naph.mvvmjetpack.view.employee_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.naph.mvvmjetpack.model.Data
import com.naph.mvvmjetpack.view.bottom_nav.NAV_EMPLOYEE_DETAIL_SCREEN

@Composable
fun EmployeeItem(
    employee: Data,
    onItemClick: (Data) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp

    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .clickable { onItemClick(employee) }
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = employee.profile_image,

                        builder = {
                            scale(Scale.FILL)
                            placeholder(coil.compose.base.R.drawable.notification_action_background)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = employee.employee_name,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)

                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {

                    Text(
                        text = employee.employee_name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = employee.employee_age.toString(),
                        style = MaterialTheme.typography.caption,

                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)

                    )
                    Text(
                        text = employee.employee_salary.toString(),
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }

            }
        }
    }
}

