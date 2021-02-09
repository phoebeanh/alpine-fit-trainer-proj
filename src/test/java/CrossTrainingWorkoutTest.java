import org.junit.Assert;
import org.junit.jupiter.api.Test;
import workouts.CrossTrainingWorkout;

public class CrossTrainingWorkoutTest {

    @Test
    public void getActivityIfNotSpecified() {
        CrossTrainingWorkout actual = new CrossTrainingWorkout("cross training", "1hr", "hard", 1,1);
        String expected = "any";
        Assert.assertEquals(expected, actual.getActivity());
    }

    @Test
    public void getActivityIfSpecified() {
        CrossTrainingWorkout actual = new CrossTrainingWorkout("cross training", "1hr", "hard", 1,1, "rock climbing");
        String expected = "rock climbing";
        Assert.assertEquals(expected, actual.getActivity());
    }

    @Test
    public void toStringShowsActivityValue() {
        CrossTrainingWorkout actual = new CrossTrainingWorkout("cross training", "1hr", "hard", 1,1, "rock climbing");
        String expected = "Workout: cross training, Duration: 1hr, Difficulty: hard, Week: 1, Day: 1, Activity: rock climbing";
        Assert.assertEquals(expected, actual.toString());
    }

}