package com.hashconcepts.composebmicalculator.ui.screens

import android.widget.Button
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
            Spacer(modifier = Modifier.height(20.dp))
            GenderSection()
            Spacer(modifier = Modifier.height(25.dp))
            HeightSection()
            Spacer(modifier = Modifier.height(25.dp))
            WeightAgeSection()
            Spacer(modifier = Modifier.height(25.dp))
            Button()
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
            .clickable { }

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
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .background(ButtonBlue)
    ) {
        Text(text = "Height", fontSize = 25.sp, style = MaterialTheme.typography.h2)
        Text(
            text = "${sliderPosition.toInt()}" + "cm",
            fontSize = 35.sp,
            style = MaterialTheme.typography.h1,
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 1f..300f,
            steps = 0,
            modifier = Modifier.padding(10.dp)
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
    var weightAgeValue by rememberSaveable {
        mutableStateOf(1)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(ButtonBlue)
            .padding(vertical = 25.dp)
            .fillMaxWidth()
            .weight(1f)
    ) {
        Text(text = sectionType, fontSize = 25.sp, style = MaterialTheme.typography.h2)
        Text(text = "$weightAgeValue", fontSize = 35.sp, style = MaterialTheme.typography.h1)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            CounterItem(counterIcon = R.drawable.ic_add) { weightAgeValue += 1 }
            Spacer(modifier = Modifier.width(10.dp))
            CounterItem(counterIcon = R.drawable.ic_minus) { weightAgeValue -= 1 }
        }
    }
}

@Composable
fun RowScope.CounterItem(counterIcon: Int, onValueChange: () -> Unit) {
    Box(modifier = Modifier
        .clip(CircleShape)
        .background(DeepBlue)
        .size(60.dp)
        .clickable { onValueChange }
    ) {
        Icon(
            painter = painterResource(id = counterIcon),
            contentDescription = "",
            tint = TextWhite,
            modifier = Modifier.size(70.dp)
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