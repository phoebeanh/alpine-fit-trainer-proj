import org.junit.Assert;
import org.junit.Test;
import workouts.StairIntervalTrainingWorkout;

public class StairIntervalTrainingWorkoutTest {

    StairIntervalTrainingWorkout actual = new StairIntervalTrainingWorkout("stair interval","1hr", "Medium", 1,1,"High-Intensity");

    @Test
    public void getIntensityIfSpecified() {
        Assert.assertEquals("High-Intensity", actual.getIntensity());
    }

    @Test
    public void getIntensityIfUnspecified() {
        actual = new StairIntervalTrainingWorkout("stair INTERVAL","1hr", "Medium",1,1);
        Assert.assertEquals("Normal Intensity", actual.getIntensity());
    }

    @Test
    public void toStringShowsIntensityValue() {
        StairIntervalTrainingWorkout actual = new StairIntervalTrainingWorkout("stair interval", "1hr", "hard", 1,1);
        String expected = "Workout: stair interval, Duration: 1hr, Difficulty: hard, Week: 1, Day: 1, Intensity: Normal Intensity";
        Assert.assertEquals(expected, actual.toString());
    }
}