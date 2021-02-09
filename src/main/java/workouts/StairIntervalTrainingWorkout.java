package workouts;

import java.util.Arrays;

/**
 * Stair climbing training is used to build up the user's aerobic and anaerobic fitness by raising
 * their anaerobic threshold.
 */
public class StairIntervalTrainingWorkout extends Workout{
    private String intensity = "Normal Intensity";

    public StairIntervalTrainingWorkout(String name, String duration, String difficulty, int week, int day) {
        super(name, duration, difficulty, week, day);
    }

    public StairIntervalTrainingWorkout(String name, String duration, String difficulty, int week, int day, String intensity) {
        super(name, duration, difficulty, week, day);
        this.intensity = intensity;
    }

    public String getIntensity() {
        return this.intensity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Intensity: " + intensity;
    }

}
