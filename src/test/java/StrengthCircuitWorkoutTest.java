import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workouts.StrengthCircuitWorkout;

import java.util.Arrays;

public class StrengthCircuitWorkoutTest {

    StrengthCircuitWorkout actual;

    @BeforeEach
    public void setUp() {
        actual = new StrengthCircuitWorkout("strength workout", "30min", "easy", 3,6);
    }

    @Test
    public void addExercise() {
        /**
         * Postcond: user new exercise added to the object's internal exercises list
         */

        actual.addExercise("new exercise");
        String[] expectedExercises = new String[]{
                "Chair squats",
                "High knees",
                "Sumo squats",
                "Bicycles",
                "Mountain climbers",
                "Push-ups",
                "Russian twists",
                "new exercise"
        };

        Assert.assertEquals(Arrays.asList(expectedExercises), actual.getExercises());
    }

    @Test
    public void removeAllExercises() {
        /**
         * Postcond: remove exercises results in empty list
         */
        actual.removeAllExercises();
        String[] expectedExercises = new String[]{};

        actual.removeAllExercises();

        Assert.assertEquals(Arrays.asList(expectedExercises), actual.getExercises());
    }

}