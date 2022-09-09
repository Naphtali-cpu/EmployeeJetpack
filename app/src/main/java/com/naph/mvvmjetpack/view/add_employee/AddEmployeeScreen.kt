package com.naph.mvvmjetpack.view.add_employee

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naph.mvvmjetpack.HiltAndroid
import com.naph.mvvmjetpack.model.AddEmployee
import com.naph.mvvmjetpack.view.employee_list.MainActivity

@Composable
fun AddEmployeeScreen(
    viewModel: AddEmployeeViewModel = viewModel()
) {

    val ctx = LocalContext.current

    val userName = remember {
        mutableStateOf(TextFieldValue())
    }
    val salary = remember {
        mutableStateOf(TextFieldValue())
    }
    val age = remember {
        mutableStateOf(TextFieldValue())
    }
    // on below line we are creating a column.
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
            text = "Add Employee",
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
        TextField(
            // on below line we are specifying value for our email text field.
            value = userName.value,
            // on below line we are adding on value change for text field.
            onValueChange = { userName.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your name") },
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
        TextField(
            // on below line we are specifying value for our email text field.
            value = salary.value,
            // on below line we are adding on value change for text field.
            onValueChange = { salary.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter Salary") },
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
        TextField(
            // on below line we are specifying value for our email text field.
            value = age.value,
            // on below line we are adding on value change for text field.
            onValueChange = { age.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter Age") },
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
                postDataUsingRetrofit(
                    ctx, userName, salary, age, viewModel
                )
            },
            // on below line we are adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Post Data", modifier = Modifier.padding(8.dp))
        }
        // on below line we are adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))
    }
}

fun postDataUsingRetrofit(
    ctx: Context,
    userName: MutableState<TextFieldValue>,
    salary: MutableState<TextFieldValue>,
    age: MutableState<TextFieldValue>,
    viewModel: AddEmployeeViewModel
) {
    Toast.makeText(ctx, userName.toString(), Toast.LENGTH_LONG).show()
    val dataModel = AddEmployee(userName.value.text, salary.value.text, age.value.text)
    viewModel.createEmployee(dataModel)
}
