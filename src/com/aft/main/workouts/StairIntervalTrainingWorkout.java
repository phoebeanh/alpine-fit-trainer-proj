package com.aft.main.workouts;

/**
 * This exercise specifies stair climbing training
 */
public class StairIntervalTrainingWorkout extends Workout{
    private String intensity = "Normal Intensity";

    public StairIntervalTrainingWorkout(String duration, String difficulty, int week, int day) {
        super(duration, difficulty, week, day);
    }

    public StairIntervalTrainingWorkout(String duration, String difficulty, int week, int day, String intensity) {
        super(duration, difficulty, week, day);
        this.intensity = intensity;
    }

    @Override
    public String getName() {
        return "Stair Interval";
    }

    public String getIntensity() {
        return this.intensity;
    }

}
