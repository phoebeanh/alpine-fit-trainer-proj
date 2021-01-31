package com.aft.main.workouts;

public class HikeWorkout extends Workout {
    private String packWeight = "N/A";
    private double mileage = 0.0;

    public HikeWorkout(String duration, String difficulty, int week, int day) {
        super(duration, difficulty, week, day);
    }

    public HikeWorkout(String duration, String difficulty, int week, int day, String packWeight, double mileage) {
        super(duration, difficulty, week, day);
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
