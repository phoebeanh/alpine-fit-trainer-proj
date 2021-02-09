import error.IllFormedWorkoutException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workouts.*;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFormatterTest {

    private List<Workout> testWorkouts = new ArrayList<>();
    private List<Workout> week1 = new ArrayList<>();
    private List<Workout> week2 = new ArrayList<>();

    // create a clean test workout list for each test
    @BeforeEach
    public void setUp() throws IllFormedWorkoutException {
        testWorkouts.clear();
        week1.add(new RainierDozenWorkout("rainier dozen", "12min", "easy",1,1));
        week1.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,2));
        week1.add(new HikeWorkout("hike", "30min", "medium", 1, 2));
        week1.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,3));
        week1.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,4));
        week1.add(new HikeWorkout("hike", "30min", "medium", 1, 4));
        week1.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,5));
        week1.add(new HikeWorkout("hike", "30min", "medium", 1, 6));
        week1.add(new Rest(1,7));
        week2.add(new StairIntervalTrainingWorkout("stair interval", "30min", "medium",2,1));
        week2.add(new CrossTrainingWorkout("cross training", "1hr", "hard", 2,2));
        week2.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 2,3));
        week2.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 2,4));
        week2.add(new Rest(2,4));
        week2.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 2,5));
        week2.add(new HikeWorkout("hike", "30min", "medium", 2, 6));
        week2.add(new StrengthCircuitWorkout("strength circuit", "1hr", "medium",2,7));

        testWorkouts.addAll(week1);
        testWorkouts.addAll(week2);
    }

    @Test
    public void getFormattedWorkoutsTest() {
        ScheduleFormatter actual = new ScheduleFormatter(testWorkouts);
        Assert.assertEquals(testWorkouts, actual.getFormattedWorkouts());
    }

    @Test
    public void getWorkoutsForWeekOneTest() {
        ScheduleFormatter actual = new ScheduleFormatter(testWorkouts);
        Assert.assertEquals(week1, actual.getWorkoutsForWeek(1));
    }

    @Test
    public void getWorkoutsForWeekTwoTest() {
        ScheduleFormatter actual = new ScheduleFormatter(testWorkouts);
        Assert.assertEquals(week2, actual.getWorkoutsForWeek(2));
    }
}