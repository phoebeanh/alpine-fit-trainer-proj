import error.IllFormedWorkoutException;
import org.junit.Assert;
import org.junit.Test;
import workouts.RainierDozenWorkout;

import java.util.Arrays;

public class RainierDozenWorkoutTest {
    private static String[] DEFAULT_EXERCISES = new String[] {
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

    @Test
    public void getExercisesReturnsExpectedArray() {
        RainierDozenWorkout actual = new RainierDozenWorkout("rainier dozen", "12min", "easy", 5,7);

        Assert.assertEquals(Arrays.asList(DEFAULT_EXERCISES), actual.getExercises());
    }

    @Test
    public void toStringShowsExercisesValue() {
        RainierDozenWorkout actual = new RainierDozenWorkout("rainier dozen", "1hr", "hard", 1,1);
        String expected = "Workout: rainier dozen, Duration: 1hr, Difficulty: hard, Week: 1, Day: 1, Exercises: " + Arrays.toString(DEFAULT_EXERCISES);
        Assert.assertEquals(expected, actual.toString());
    }

}