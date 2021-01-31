package com.aft.test;

import com.aft.workouts.*;

import java.util.ArrayList;
import java.util.List;

public class WorkoutExampleTest {

    private static List<List<Workout>> workoutsForWeek = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=========WorkoutExampleTest==========");
        createWorkoutsForWeek();
        displayWorkouts();
    }

    private static void displayWorkouts() {
        /**
         *
         * Precondition: A list of lists containing each day's workout(s)
         * Postcondition: The name, duration, and difficulty of each day's workout(s) will be printed to the console, if applicable, otherwise, print Rest
         * Postcondition2: If the day's workout is a hike, and contains pack weight and mileage variables, those will also be printed.
         * Postcondition3: If the day's workout includes sub-exercises, print the exercises
         * Postcondition4: If the day's workout is cross training, print the activity name
         */

        System.out.println("=========Should have 7 Days==========");
        System.out.println("=========Day 1 & 2 Should have 2 Workouts ==========");
        System.out.println("=========Days 3 & 5 Should be Rest Days==========");

        int currentDay = 1;
        for (List<Workout> day : workoutsForWeek) {
            System.out.println("Day " + currentDay + " Objective(s):");
            if (day.isEmpty())
                System.out.println("Rest");
            for (Workout workout : day) {
                System.out.print("Workout: " + workout.getName() + " | Duration: " + workout.getDuration() + " | Difficulty: " + workout.getDifficulty());

                if (workout instanceof HikeWorkout) {
                    HikeWorkout hike = (HikeWorkout) workout;
                    if (hike.getMileage() != 0.0) {
                        System.out.print(" | Pack Weight: " + hike.getPackWeight() + " | Mileage: " + hike.getMileage());
                    }
                } else if (workout instanceof RainierDozenWorkout) {
                    System.out.print(" | Exercises: " + ((RainierDozenWorkout) workout).getExercises());
                } else if (workout instanceof StrengthCircuitWorkout) {
                    System.out.print(" | Exercises: " + ((StrengthCircuitWorkout) workout).getExercises());
                } else if (workout instanceof CrossTrainingWorkout) {
                    System.out.print(" | Activity: " + ((CrossTrainingWorkout) workout).getActivity());
                }
                System.out.println();
            }
            currentDay++;
            System.out.println();
        }
    }

    private static void createWorkoutsForWeek() {
        /**
         * Postcondition: The List workoutsForWeek will be populated with workouts for each day of week
         */
        List<Workout> day1Workouts = new ArrayList<>();
        day1Workouts.add(new RainierDozenWorkout("12min", "Easy"));
        day1Workouts.add(new HikeWorkout("30min", "Easy"));
        workoutsForWeek.add(day1Workouts);

        List<Workout> day2Workouts = new ArrayList<>();
        day2Workouts.add(new RainierDozenWorkout("12min", "Easy"));
        day2Workouts.add(new StairIntervalTraining("40min", "Medium"));
        workoutsForWeek.add(day2Workouts);

        // rest day
        List<Workout> day3Workouts = new ArrayList<>();
        workoutsForWeek.add(day3Workouts);

        List<Workout> day4Workouts = new ArrayList<>();
        day4Workouts.add(new StrengthCircuitWorkout("25min", "Hard"));
        workoutsForWeek.add(day4Workouts);

        // rest day
        List<Workout> day5Workouts = new ArrayList<>();
        workoutsForWeek.add(day5Workouts);

        List<Workout> day6Workouts = new ArrayList<>();
        day6Workouts.add(new CrossTrainingWorkout("1hr", "Medium", "Bouldering"));
        workoutsForWeek.add(day6Workouts);

        List<Workout> day7Workouts = new ArrayList<>();
        day7Workouts.add(new HikeWorkout("2hr", "Medium", "N/A", 4.0));
        workoutsForWeek.add(day7Workouts);
    }
}
