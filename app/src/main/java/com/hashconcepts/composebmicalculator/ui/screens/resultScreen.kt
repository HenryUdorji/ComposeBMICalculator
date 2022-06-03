package com.hashconcepts.composebmicalculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hashconcepts.composebmicalculator.ui.components.ToolbarSection
import com.hashconcepts.composebmicalculator.ui.theme.*

/**
 * @created 31/05/2022 - 11:13 AM
 * @project ComposeBMICalculator
 * @author  ifechukwu.udorji
 */

@Composable
fun ResultScreen(
    bmi: String,
    weightRange: String,
    message: String,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 5.dp)
        ) {
            ToolbarSection(showBackArrow = true) {
                navController.navigate(Screens.HomeScreen.route)
            }
            Text(
                text = "Your Result",
                fontFamily = gothicA1,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
            )
            ResultSection(bmi, weightRange, message)
            Spacer(modifier = Modifier.height(20.dp))
            Button(navController = navController)
        }
    }
}

@Composable
fun ColumnScope.ResultSection(
    bmi: String,
    weightRange: String,
    message: String
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(15.dp))
            .background(ButtonBlue)
            .fillMaxWidth()
    ) {
        Text(
            text = weightRange,
            style = MaterialTheme.typography.h1,
            color = Teal200,
            fontSize = 30.sp
        )
        Text(
            text = bmi, fontFamily = gothicA1,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = message,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}

@Composable
fun Button(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(ButtonBlue)
            .fillMaxWidth()
            .height(60.dp)
            .clickable(onClick = {
                navController.navigate(Screens.HomeScreen.route)
            })
    ) {
        Text(
            text = "Re-Calculate BMI",
            style = MaterialTheme.typography.h2,
            color = TextWhite
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    ComposeBMICalculatorTheme {
        ResultScreen(
            "25.0",
            "Normal",
            "You are normal",
            rememberNavController()
        )
    }
}