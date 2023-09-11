package `Kotline exercises`

import java.util.Scanner

/*
There are three main temperature scales used in the world: Celsius, Fahrenheit, and Kelvin.

In the initial code provided in the following code snippet, write a program that converts a
temperature from one scale to another with these formulas:

Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
Kelvin to Celsius: ° C = K - 273.15
Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15
Note that the String.format("%.2f", /* measurement */ ) method is used to convert a number
into a String type with 2 decimal places.
 */



fun main() {
    val scanner = Scanner(System.`in`)

    print("Print the celsius: ")
    val celsius = scanner.nextDouble()
    val Fahrenheit = (1.8 * celsius) + 32
    val Kelvin = celsius + 273.15
    printFinalTemperature(celsius, "Celsius", "Fahrenheit", Fahrenheit)
    printFinalTemperature(Fahrenheit, "Fahrenheit", "Kelvin", Kelvin)

}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    finalConversion : Double
) {
    val finalMeasurement = String.format("%.2f", finalConversion) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}