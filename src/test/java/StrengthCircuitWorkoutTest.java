import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workouts.StrengthCircuitWorkout;

import java.util.Arrays;

public class StrengthCircuitWorkoutTest {

    StrengthCircuitWorkout actual;
    private static String[] EXPECTED_EXERCISES = new String[]{
            "Chair squats",
            "High knees",
            "Sumo squats",
            "Bicycles",
            "Mountain climbers",
            "Push-ups",
            "Russian twists",
            "new exercise"
    };

    @BeforeEach
    public void setUp() {
        actual = new StrengthCircuitWorkout("strength workout", "30min", "easy", 3,6);
    }

    @Test
    public void addExerciseTest() {
        /**
         * Postcond: user new exercise added to the object's internal exercises list
         */

        actual.addExercise("new exercise");

        Assert.assertEquals(Arrays.asList(EXPECTED_EXERCISES), actual.getExercises());
    }

    @Test
    public void removeAllExercisesTest() {
        /**
         * Postcond: remove exercises results in empty list
         */
        actual.removeAllExercises();
        String[] expectedExercises = new String[]{};

        actual.removeAllExercises();

        Assert.assertEquals(Arrays.asList(expectedExercises), actual.getExercises());
    }

    @Test
    public void toStringShowsExercisesValueTest() {
        StrengthCircuitWorkout actual = new StrengthCircuitWorkout("strength circuit", "1hr", "hard", 1,1);
        String expected = "Workout: strength circuit, Duration: 1hr, Difficulty: hard, Week: 1, Day: 1, Exercises: " + Arrays.toString(new String[] {
                "Chair squats",
                "High knees",
                "Sumo squats",
                "Bicycles",
                "Mountain climbers",
                "Push-ups",
                "Russian twists"
        });
        Assert.assertEquals(expected, actual.toString());
    }

}