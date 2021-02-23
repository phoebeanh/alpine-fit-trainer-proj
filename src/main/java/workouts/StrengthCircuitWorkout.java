package workouts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Strength training is used as part of the 3-pronged approach to mountain fitness. These exercises can vary per week,
 * but a default list of exercises is provided.
 */
public class StrengthCircuitWorkout extends Workout implements Serializable {

    private List<String> exercises = new ArrayList<>();
    private static final String[] DEFAULT_EXERCISES = new String[]{
            "Chair squats",
            "High knees",
            "Sumo squats",
            "Bicycles",
            "Mountain climbers",
            "Push-ups",
            "Russian twists"
    };

    public StrengthCircuitWorkout(String name, String duration, String difficulty, int week, int day) {
        super(name, duration, difficulty, week, day);
        this.exercises.addAll(Arrays.asList(DEFAULT_EXERCISES));
    }

    public String getName() {
        return "Strength Circuit";
    }

    public void addExercise(String exercise) {
        this.exercises.add(exercise);
    }

    public void removeAllExercises() {
        this.exercises.clear();
    }

    public List<String> getExercises() {
        // precondition: the list of exercises is not empty
        return exercises;
    }

    @Override
    public String toString() {
        return super.toString() + ", Exercises: " + Arrays.toString(exercises.toArray());
    }

    @Override
    public String[] toStringArray() {
        List<String> data = new ArrayList<>();
        data.addAll(Arrays.asList(super.toStringArray()));
        data.add(this.exercises.toString());
        return data.toArray(new String[data.size()]);
    }
}
