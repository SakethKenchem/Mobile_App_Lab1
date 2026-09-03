//https://docs.google.com/document/d/1e2AQSSqJmqv7uwNgJjJbOsn64pQqZ9DW6vjsPcdRLYY/edit?usp=sharing
/*
Andrew Mutero - 150736
Saketh Kenchem - 152324
Murji Viqarhussein - 193642
Mark Kipruto - 169386
Lewis Kamunjeru - 155669
 */

import java.util.Scanner

const val STEP_GOAL = 10000

fun main() {
    val scanner = Scanner(System.`in`)

    println("=== Welcome to Health & Fitness Tracker ===\n")

    //Profile Setup
    print("Enter your name: ")
    val userName: String = scanner.nextLine()

    print("Enter weight in kg (e.g., 65.0): ")
    val weightKg: Double = scanner.nextDouble()

    print("Select Goal (1: Maintain, 2: Gain, 3: Lose): ")
    val goalChoice: Int = scanner.nextInt()

    //Set Goals
    var goalType = "Weight Maintenance"
    var targetCalories = 2500

    if (goalChoice == 2) {
        goalType = "Weight Gain"
        targetCalories = if (weightKg > 60) 4500 else 3000
    } else if (goalChoice == 3) {
        goalType = "Weight Loss"
        targetCalories = if (weightKg > 70) 3500 else 2000
    } else {
        targetCalories = if (weightKg > 70) 4000 else 2500
    }

    println("\nTarget for $userName ($goalType): $targetCalories kcal\n")

    //Workout Tracking
    val workouts = mutableListOf<String>()
    var caloriesOut = 0

    println("How many workouts today? (Enter 0 if none): ")

    val workoutCount = scanner.nextInt()
    scanner.nextLine()

    for (i in 1..workoutCount) {
        print("Workout $i name: ")
        val name = scanner.nextLine()

        print("Calories burned doing $name: ")
        val cals = scanner.nextInt()

        scanner.nextLine()

        workouts.add("$name (-$cals kcal)")
        caloriesOut += cals     }

    //Step Tracking
    println("Steps walked today: ")

    val steps = scanner.nextInt()

// Step assessment
if (steps >= STEP_GOAL) {
    println("Steps: Awesome job hitting your step goal!")
} else {
    println("Steps: Keep walking! You need ${STEP_GOAL - steps} more steps.")
}

// Calorie assessment
if (goalChoice == 3 && netCalories <= targetCalories) {
    println("Calories: Great job staying under your limit for weight loss!")
} else if (goalChoice != 3 && netCalories >= targetCalories) {
    println("Calories: Great job hitting your intake target!")
} else {
    println("Calories: Target missed today. Adjust your meals or workouts tomorrow.")
}

}
