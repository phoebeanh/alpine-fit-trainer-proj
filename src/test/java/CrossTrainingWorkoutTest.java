import org.junit.Assert;
import org.junit.jupiter.api.Test;
import workouts.CrossTrainingWorkout;

class CrossTrainingWorkoutTest {

    @Test
    void getActivityIfNotSpecified() {
        CrossTrainingWorkout actual = new CrossTrainingWorkout("cross training", "1hr", "hard", 1,1);
        String expected = "any";
        Assert.assertEquals(expected, actual.getActivity());
    }

    @Test
    void getActivityIfSpecified() {
        CrossTrainingWorkout actual = new CrossTrainingWorkout("cross training", "1hr", "hard", 1,1, "rock climbing");
        String expected = "rock climbing";
        Assert.assertEquals(expected, actual.getActivity());
    }
}