package com.hashconcepts.composebmicalculator.ui.screens

/**
 * @created 03/06/2022 - 11:32 AM
 * @project ComposeBMICalculator
 * @author  ifechukwu.udorji
 */
sealed class Screens(val route: String) {
    object HomeScreen: Screens("Home")
    object ResultScreen: Screens("Result")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}