package workouts;

import error.IllFormedWorkoutException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Hike workout will vary throughout the course of the training program. Early weeks hikes will be shorter
 * (30-min to 1hr), easier, and can consist of walks around the neighborhood, while later hikes may be strenuous,
 * involve elevation gain, and can take multiple hours to complete.
 */
public class HikeWorkout extends Workout implements Serializable {
    private String packWeight = "N/A";
    private double mileage = 0.0;

    public HikeWorkout(String name, String duration, String difficulty, int week, int day) throws IllFormedWorkoutException {
        super(name, duration, difficulty, week, day);
        if (!name.equalsIgnoreCase("hike"))
            throw new IllFormedWorkoutException("Hike workout is malformed.");
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

    @Override
    public String toString() {
        return super.toString() + ", Pack Weight: " + packWeight + ", Mileage: " + mileage;
    }

    @Override
    public String[] toStringArray() {
        List<String> data = new ArrayList<>();
        data.addAll(Arrays.asList(super.toStringArray()));
        data.add(this.packWeight);
        data.add(String.valueOf(this.mileage));
        return data.toArray(new String[data.size()]);
    }
}
