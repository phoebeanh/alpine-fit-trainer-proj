package com.aft.workouts;

public class CrossTrainingWorkout extends Workout {
    private String activity = "";

    public CrossTrainingWorkout(String duration, String difficulty) {
        super(duration, difficulty);
    }

    public CrossTrainingWorkout(String duration, String difficulty, String activity) {
        super(duration, difficulty);
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String getName() {
        return "Cross Training";
    }
}
