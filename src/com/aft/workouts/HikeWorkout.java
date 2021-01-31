package com.aft.workouts;

public class HikeWorkout extends Workout {
    private String packWeight = "N/A";
    private double mileage = 0.0;

    public HikeWorkout(String duration, String difficulty) {
        super(duration, difficulty);
    }

    public HikeWorkout(String duration, String difficulty, String packWeight, double mileage) {
        super(duration, difficulty);
        this.packWeight = packWeight;
        this.mileage = mileage;
    }

    @Override
    public String getName() {
        return "Hike";
    }

    public String getPackWeight() {
        return packWeight;
    }

    public double getMileage() {
        return mileage;
    }
}
