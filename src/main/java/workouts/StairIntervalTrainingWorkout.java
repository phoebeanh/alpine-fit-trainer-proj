package workouts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Stair climbing training is used to build up the user's aerobic and anaerobic fitness by raising
 * their anaerobic threshold. Stair climbing can vary in intensity during the training program.
 */
public class StairIntervalTrainingWorkout extends Workout implements Serializable {
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

    @Override
    public String[] toStringArray() {
        List<String> data = new ArrayList<>();
        data.addAll(Arrays.asList(super.toStringArray()));
        data.add(this.intensity);
        return data.toArray(new String[data.size()]);
    }
}
