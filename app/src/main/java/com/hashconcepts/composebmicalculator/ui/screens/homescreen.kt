package com.hashconcepts.composebmicalculator.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hashconcepts.composebmicalculator.R
import com.hashconcepts.composebmicalculator.ui.theme.*

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
        LazyColumn {
            item {
                ToolbarSection()
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                GenderSection()
                Spacer(modifier = Modifier.height(25.dp))
            }
            item {
                HeightSection()
                Spacer(modifier = Modifier.height(25.dp))
            }
            item {
                WeightAgeSection()
                Spacer(modifier = Modifier.height(25.dp))
            }
            item {
                Button()
            }
        }
    }
}

@Composable
fun ToolbarSection() {
    Text(
        text = "BMI CALCULATOR",
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun GenderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        GenderSectionItem("Male", R.drawable.ic_male)
        Spacer(modifier = Modifier.width(20.dp))
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
            .clickable { }

    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "",
            tint = Color.Unspecified,
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
    var heightState by remember { mutableStateOf(1f) }
    val height = buildAnnotatedString {
        withStyle(
            style = SpanStyle(fontSize = 35.sp, fontFamily = gothicA1)
        ) { append(heightState.toInt().toString()) }
        append(" cm")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .background(ButtonBlue)
    ) {
        Text(text = "Height", fontSize = 25.sp, style = MaterialTheme.typography.h2)
        Text(
            text = "$height",
            fontSize = 35.sp,
            style = MaterialTheme.typography.h1,
        )
        Slider(
            value = heightState,
            onValueChange = { heightState = it },
            valueRange = 1f..300f,
            steps = 0,
            modifier = Modifier.padding(10.dp),
            colors = SliderDefaults.colors(
                activeTickColor = DeepBlue,
                thumbColor = DeepBlue
            )
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
fun RowScope.WeightAgeSectionItem(
    sectionType: String,
    range: IntRange = 1..100
) {
    var numberPickerState by remember { mutableStateOf(1) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(ButtonBlue)
            .padding(vertical = 20.dp)
            .fillMaxWidth()
            .weight(1f)
    ) {
        Text(text = sectionType, fontSize = 25.sp, style = MaterialTheme.typography.h2)
        Text(text = "$numberPickerState", fontSize = 35.sp, style = MaterialTheme.typography.h1)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            CounterItem(counterIcon = R.drawable.ic_add) {
                if (numberPickerState < range.last) {
                    numberPickerState += 1
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            CounterItem(counterIcon = R.drawable.ic_minus) {
                if (numberPickerState > range.first) {
                    numberPickerState -= 1
                }
            }
        }
    }
}

@Composable
fun RowScope.CounterItem(counterIcon: Int, onClick: () -> Unit) {
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(DeepBlue)
        .size(50.dp)
        .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = counterIcon),
            contentDescription = "",
            tint = TextWhite,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun Button() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(ButtonBlue)
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(text = "Calculate BMI", style = MaterialTheme.typography.h2, color = TextWhite)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBMICalculatorTheme {
        HomeScreen()
    }
}