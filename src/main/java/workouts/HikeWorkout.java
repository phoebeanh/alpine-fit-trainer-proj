package workouts;

import error.IllFormedWorkout;

public class HikeWorkout extends Workout {
    private String packWeight = "N/A";
    private double mileage = 0.0;

    public HikeWorkout(String name, String duration, String difficulty, int week, int day) throws IllFormedWorkout {
        super(name, duration, difficulty, week, day);
        if (!name.equalsIgnoreCase("hike"))
            throw new IllFormedWorkout();
    }

    public HikeWorkout(String name, String duration, String difficulty, int week, int day, String packWeight, double mileage) {
        super(name, duration, difficulty, week, day);
        this.packWeight = packWeight;
        this.mileage = mileage;
    }

    public String getPackWeight() {
        return packWeight;
    }

    public double getMileage() {
        return mileage;
    }
}
