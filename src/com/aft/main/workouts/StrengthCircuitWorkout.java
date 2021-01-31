package com.aft.main.workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrengthCircuitWorkout extends Workout {

    private List<String> exercises = new ArrayList<>();
    private static final String[] DEFAULT_EXERCISES = new String[]{
            "Chair squats",
            "High knees",
            "Sumo squats",
            "Bicycles",
            "Mountain climbers",
            "Push-ups",
            "Russian twists"
    };

    public StrengthCircuitWorkout(String duration, String difficulty, int week, int day) {
        super(duration, difficulty, week, day);
        this.exercises.addAll(Arrays.asList(DEFAULT_EXERCISES));
    }

    @Override
    public String getName() {
        return "Strength Circuit";
    }

    public void addExercise(String exercise) {
        this.exercises.add(exercise);
    }

    public void removeAllExercises() {
        this.exercises.clear();
    }

    public List<String> getExercises() {
        // precondition: the list of exercises is not empty
        return exercises;
    }
}
