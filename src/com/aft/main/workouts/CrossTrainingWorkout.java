package com.aft.main.workouts;

public class CrossTrainingWorkout extends Workout {
    private String activity = "";

    public CrossTrainingWorkout(String duration, String difficulty, int week, int day) {
        super(duration, difficulty, week, day);
    }

    public CrossTrainingWorkout(String duration, String difficulty, int week, int day, String activity) {
        super(duration, difficulty, week, day);
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
