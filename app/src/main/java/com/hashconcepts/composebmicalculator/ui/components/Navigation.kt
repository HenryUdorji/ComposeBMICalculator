package com.hashconcepts.composebmicalculator.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hashconcepts.composebmicalculator.ui.ARGS_BMI
import com.hashconcepts.composebmicalculator.ui.ARGS_MESSAGE
import com.hashconcepts.composebmicalculator.ui.ARGS_WEIGHT_RANGE
import com.hashconcepts.composebmicalculator.ui.screens.HomeScreen
import com.hashconcepts.composebmicalculator.ui.screens.ResultScreen
import com.hashconcepts.composebmicalculator.ui.screens.Screens

/**
 * @created 03/06/2022 - 11:29 AM
 * @project ComposeBMICalculator
 * @author  ifechukwu.udorji
 */

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            Screens.ResultScreen.route + "/{$ARGS_BMI}/{$ARGS_WEIGHT_RANGE}/{$ARGS_MESSAGE}",
            arguments = listOf(
                navArgument(ARGS_BMI) {
                    type = NavType.StringType
                },
                navArgument(ARGS_WEIGHT_RANGE) {
                    type = NavType.StringType
                },
                navArgument(ARGS_MESSAGE) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            ResultScreen(
                bmi = entry.arguments?.getString(ARGS_BMI).toString(),
                weightRange = entry.arguments?.getString(ARGS_WEIGHT_RANGE).toString(),
                message = entry.arguments?.getString(ARGS_MESSAGE).toString(),
                navController = navController
            )
        }

    }
}