package com.hashconcepts.composebmicalculator.ui.components

import android.widget.Toolbar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hashconcepts.composebmicalculator.R
import com.hashconcepts.composebmicalculator.ui.screens.ResultScreen
import com.hashconcepts.composebmicalculator.ui.theme.ComposeBMICalculatorTheme
import com.hashconcepts.composebmicalculator.ui.theme.DeepBlue
import com.hashconcepts.composebmicalculator.ui.theme.TextWhite

/**
 * @created 03/06/2022 - 10:10 AM
 * @project ComposeBMICalculator
 * @author  ifechukwu.udorji
 */

@Composable
fun ToolbarSection(
    showBackArrow: Boolean = false,
    onBackArrowClicked: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(10.dp)
    ) {
        if (showBackArrow) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back Arrow",
                tint = TextWhite,
                modifier = Modifier
                    .size(30.dp)
                    .clickable(onClick = onBackArrowClicked)
            )
        }
        Text(
            text = "BMI CALCULATOR",
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarPreview() {
    ComposeBMICalculatorTheme {
        ToolbarSection(onBackArrowClicked = {})
    }
}