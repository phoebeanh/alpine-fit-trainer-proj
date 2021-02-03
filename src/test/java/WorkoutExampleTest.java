import error.IllFormedWorkout;
import org.junit.Before;
import org.junit.Test;
import workouts.*;

import java.util.ArrayList;
import java.util.List;

public class WorkoutExampleTest {

    private static List<List<Workout>> workoutsForWeek = new ArrayList<>();

    @Before
    public void setUp() throws IllFormedWorkout {
        System.out.println("=========WorkoutExampleTest==========");
        createWorkoutsForWeek();
    }

    @Test
    public void displayWorkoutsTest() {
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

    private static void createWorkoutsForWeek() throws IllFormedWorkout {
        /**
         * Postcondition: The List workoutsForWeek will be populated with workouts for each day of week
         */
        List<Workout> day1Workouts = new ArrayList<>();
        day1Workouts.add(new RainierDozenWorkout("Rainier Dozen", "12min", "Easy",1,1));
        day1Workouts.add(new HikeWorkout("Hike", "30min", "Easy", 1, 1));
        workoutsForWeek.add(day1Workouts);

        List<Workout> day2Workouts = new ArrayList<>();
        day2Workouts.add(new RainierDozenWorkout("Rainier Dozen", "12min", "Easy",1,2));
        day2Workouts.add(new StairIntervalTrainingWorkout("Stair Interval", "40min", "Medium",1,2));
        workoutsForWeek.add(day2Workouts);

        // rest day
        List<Workout> day3Workouts = new ArrayList<>();
        day3Workouts.add(new Rest("rest","","",1,3));
        workoutsForWeek.add(day3Workouts);

        List<Workout> day4Workouts = new ArrayList<>();
        day4Workouts.add(new StrengthCircuitWorkout("Strength Circuit", "25min", "Hard",1,4));
        workoutsForWeek.add(day4Workouts);

        // rest day
        List<Workout> day5Workouts = new ArrayList<>();
        day5Workouts.add(new Rest(1,5));
        workoutsForWeek.add(day5Workouts);

        List<Workout> day6Workouts = new ArrayList<>();
        day6Workouts.add(new CrossTrainingWorkout("Cross Training","1hr", "Medium", 1,6,"Bouldering"));
        workoutsForWeek.add(day6Workouts);

        List<Workout> day7Workouts = new ArrayList<>();
        day7Workouts.add(new HikeWorkout("Hike", "2hr", "Medium", 1, 7, "N/A", 4.0));
        workoutsForWeek.add(day7Workouts);
    }
}
