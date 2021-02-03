import org.junit.Assert;
import org.junit.Test;
import workouts.RainierDozenWorkout;

import java.util.Arrays;

public class RainierDozenWorkoutTest {
    @Test
    public void getExercisesReturnsExpectedArray() {
        RainierDozenWorkout actual = new RainierDozenWorkout("rainier dozen", "12min", "easy", 5,7);
        String[] expected = new String[] {
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

        Assert.assertEquals(Arrays.asList(expected), actual.getExercises());
    }

}