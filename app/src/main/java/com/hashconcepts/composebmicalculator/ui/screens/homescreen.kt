package com.hashconcepts.composebmicalculator.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hashconcepts.composebmicalculator.R
import com.hashconcepts.composebmicalculator.ui.theme.ButtonBlue
import com.hashconcepts.composebmicalculator.ui.theme.ComposeBMICalculatorTheme
import com.hashconcepts.composebmicalculator.ui.theme.DeepBlue
import com.hashconcepts.composebmicalculator.ui.theme.TextWhite

/**
 * @created 31/05/2022 - 11:13 AM
 * @project ComposeBMICalculator
 * @author  ifechukwu.udorji
 */
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            ToolbarSection()
            Spacer(modifier = Modifier.height(10.dp))
            GenderSection()
            Spacer(modifier = Modifier.height(10.dp))
            HeightSection()
            Spacer(modifier = Modifier.height(10.dp))
            WeightAgeSection()
        }
    }
}

@Composable
fun ToolbarSection() {
    Text(
        text = "BMI CALCULATOR",
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@Composable
fun GenderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        GenderSectionItem("Male", R.drawable.ic_male)
        Spacer(modifier = Modifier.width(10.dp))
        GenderSectionItem("Female", R.drawable.ic_female)
    }
}

@Composable
fun RowScope.GenderSectionItem(gender: String, @DrawableRes iconId: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(ButtonBlue)
            .padding(horizontal = 40.dp, vertical = 25.dp)
            .fillMaxWidth()
            .weight(1f)

    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "",
            tint = TextWhite,
            modifier = Modifier.size(70.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = gender,
            style = MaterialTheme.typography.h2,
        )
    }
}

@Composable
fun HeightSection() {
    var sliderPosition by remember { mutableStateOf(1f) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(ButtonBlue)
    ) {
        Text(text = "Height", fontSize = 25.sp, style = MaterialTheme.typography.h2)
        Text(text = "${sliderPosition.toInt()}"+"cm", fontSize = 35.sp, style = MaterialTheme.typography.h1)
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 1f..300f,
            steps = 1,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
    }
}

@Composable
fun WeightAgeSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeightAgeSectionItem("Weight")
        Spacer(modifier = Modifier.width(20.dp))
        WeightAgeSectionItem("Age")
    }
}

@Composable
fun RowScope.WeightAgeSectionItem(sectionType: String) {
    var weightAgeValue by remember {
        mutableStateOf(1)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 40.dp, vertical = 25.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(ButtonBlue)
            .fillMaxWidth()
            .weight(1f)
    ){
        Text(text = "Weight", fontSize = 25.sp, style = MaterialTheme.typography.h2)
        Text(text = "$weightAgeValue", fontSize = 35.sp, style = MaterialTheme.typography.h1)
        Row {
            Box() {
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBMICalculatorTheme {
        HomeScreen()
    }
}