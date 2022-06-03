package com.hashconcepts.composebmicalculator.ui

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

/**
 * @created 02/06/2022 - 9:25 PM
 * @project ComposeBMICalculator
 * @author  ifechukwu.udorji
 */
object Util {

    fun calculateBMI(weight: Int, height: Int): BmiResult {
        //convert height to meters then square it
        val convertedHeight = ((height.toDouble() / 100.0).pow(2.0))
        val bmi = (weight.toDouble() / convertedHeight).roundOff()

        val message = processMessage(bmi)
        return BmiResult(bmi, message.first, message.second)
    }

    /****
     * Uses the BMI to generate appropriate weight range and message
     */
    private fun processMessage(bmi: Double): Pair<String, String> {
        if (bmi < 18.5) {
            return Pair("Underweight", "You are underweight. You need to eat more")
        }
        if (bmi in 18.5..24.9) {
            return Pair("Normal", "You have a normal body weight. Good job")
        }
        if (bmi in 25.0..30.0) {
            return Pair("Overweight", "You are overweight. You need to exercise more.")
        }
        if (bmi > 30.0) {
            return Pair("Obese", "You are obese. You really need to watch it.")
        }
        return Pair("", "")
    }

    private fun Double.roundOff(): Double {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        return df.format(this).toDouble()
    }
}

data class BmiResult(
    val bmi: Double,
    val weightRange: String,
    val message: String,
)

const val ARGS_BMI = "bmi"
const val ARGS_WEIGHT_RANGE = "weightRange"
const val ARGS_MESSAGE = "message"