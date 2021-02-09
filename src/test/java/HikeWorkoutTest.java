import error.IllFormedWorkoutException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workouts.HikeWorkout;

import static org.junit.jupiter.api.Assertions.*;

public class HikeWorkoutTest {

    HikeWorkout actual;

    @BeforeEach
    public void setUp() throws IllFormedWorkoutException {
        actual = new HikeWorkout("hike", "1hr", "easy", 4,6);
    }

    @Test
    public void getPackWeight() {
        String expected = "N/A";
        Assert.assertEquals(expected, actual.getPackWeight());
    }

    @Test
    public void getMileage() {
        double expected = 0.0;
        assertEquals(expected, actual.getMileage());
    }

    @Test
    public void throwsIllFormedWorkoutException() {
        try {
            HikeWorkout illFormed = new HikeWorkout("not a hike", "1hr", "hard", 1, 2);
        } catch (IllFormedWorkoutException e) {
            Assert.assertEquals("IllFormedWorkout Occurred: Workout does not match correct syntax", e.getMessage());
        }
    }

    @Test
    public void toStringShowsPackWeightAndMileageValues() throws IllFormedWorkoutException {
        HikeWorkout actual = new HikeWorkout("hike", "1hr", "hard", 1,1);
        String expected = "Workout: hike, Duration: 1hr, Difficulty: hard, Week: 1, Day: 1, Pack Weight: N/A, Mileage: 0.0";
        Assert.assertEquals(expected, actual.toString());
    }
}