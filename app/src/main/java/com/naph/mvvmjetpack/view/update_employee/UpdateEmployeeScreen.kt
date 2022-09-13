package com.naph.mvvmjetpack.view.update_employee

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naph.mvvmjetpack.model.AddEmployee

@Composable
fun UpdateEmployeeScreen(
    id: String,
    updateViewModel: UpdateEmployeeViewModel = viewModel()
) {
    val context = LocalContext.current

    val userNameUpdate = remember {
        mutableStateOf(TextFieldValue())
    }

    val salaryUpdate = remember {
        mutableStateOf(TextFieldValue())
    }

    val ageUpdate = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(
        // on below line we are adding a modifier to it
        // and setting max size, max height and max width
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        // on below line we are adding vertical
        // arrangement and horizontal alignment.
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // on below line we are creating a text
        Text(
            // on below line we are specifying text as
            // Session Management in Android.
            text = "Update Employee",
            // on below line we are specifying text color.
//            color = greenColor,
            fontSize = 20.sp,
            // on below line we are specifying font family
            fontFamily = FontFamily.Default,
            // on below line we are adding font weight
            // and alignment for our text
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
        //on below line we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))
        // on below line we are creating a text field for our employee name.
        OutlinedTextField(
            // on below line we are specifying value for our email text field.
            value = userNameUpdate.value,
            // on below line we are adding on value change for text field.
            onValueChange = { userNameUpdate.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Update Employee Name") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we ar adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))
        // on below line we are creating a text field for our salary.
        OutlinedTextField(
            // on below line we are specifying value for our email text field.
            value = salaryUpdate.value,
            // on below line we are adding on value change for text field.
            onValueChange = { salaryUpdate.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Update Salary") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we ar adding single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(5.dp))
        // on below line we are creating a text field for our employee age.
        OutlinedTextField(
            // on below line we are specifying value for our email text field.
            value = ageUpdate.value,
            // on below line we are adding on value change for text field.
            onValueChange = { ageUpdate.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Update Age") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we ar adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(10.dp))
        // on below line we are creating a button
        Button(
            onClick = {
                // on below line we are calling make payment method to update data.
                updateEmployee(
                    context, userNameUpdate, salaryUpdate, ageUpdate, updateViewModel, id
                )
            },
            // on below line we are adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Update Employee", modifier = Modifier.padding(8.dp))
        }
        // on below line we are adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))
    }
}


fun updateEmployee(
    context: Context,
    userNameUpdate: MutableState<TextFieldValue>,
    salaryUpdate: MutableState<TextFieldValue>,
    ageUpdate: MutableState<TextFieldValue>,
    updateViewModel: UpdateEmployeeViewModel,
    id: String
) {
    val updateData = AddEmployee(userNameUpdate.value.text, salaryUpdate.value.text, ageUpdate.value.text, id)
    updateViewModel.updateEmployee(id, updateData)
}