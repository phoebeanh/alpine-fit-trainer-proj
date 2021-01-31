package com.aft.workouts;

/**
 * This exercise specifies stair climbing training
 */
public class StairIntervalTraining extends Workout{
    private String intensity = "Normal Intensity";

    public StairIntervalTraining(String duration, String difficulty) {
        super(duration, difficulty);
    }

    public StairIntervalTraining(String duration, String difficulty, String intensity) {
        super(duration, difficulty);
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
