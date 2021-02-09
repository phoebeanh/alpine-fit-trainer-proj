package workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Rainier Dozen is a set of exercises specified in the book, "Fit to Climb" by John Colver.
 * It consists of 12 exercises that help to strengthen muscles and stay in shape. These are a class
 * variable constant since these will not change.
 */
public class RainierDozenWorkout extends Workout{

    private List<String> exercises = new ArrayList<>();
    private static final String[] RAINIER_DOZEN = new String[]{
            "Steam engines",
            "Chair squats",
            "Lunges",
            "Arm extenders",
            "Triceps dips",
            "Sumo squats",
            "Bicycles",
            "Mountain climbers",
            "Push-ups",
            "Russian twists",
            "Ranger crawls",
            "8-point body builders"
    };

    public RainierDozenWorkout(String name, String duration, String difficulty, int week, int day) {
        // precondition: Strings are not null
        super(name, duration, difficulty, week, day);
        this.exercises.addAll(Arrays.asList(RAINIER_DOZEN));
    }

    public List<String> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return super.toString() + ", Exercises: " + Arrays.toString(RAINIER_DOZEN);
    }
}
