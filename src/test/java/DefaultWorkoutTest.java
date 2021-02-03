import error.IllFormedWorkout;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import workouts.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DefaultWorkoutTest {

    private Path workingDir;

    @Before
    public void setUp() {
        // Precond: set up relative path to test data
        this.workingDir = Paths.get("", "src/test/resources");
    }

    @Test
    public void ValidIntakeDefaultWorkoutTest() throws IllFormedWorkout {
        /**
         * Precondition: Have test file named 'default.csv' in /src/com/aft/test resource's folder
         * Precond2: Create expected lists for each type of workout expected to come from the file:
         * rainier dozen, hike, rest, stair interval, and strength.
         * These were made for two hypothetical weeks of a schedule
         *
         * Postcondition: Assert that the preformed test file creates the workout objects expected in
         * our lists
         */
        DefaultWorkout actual = new DefaultWorkout(workingDir.resolve("default.csv").toString());

        List<RainierDozenWorkout> expectedRD = new ArrayList<>();
        List<HikeWorkout> expectedHike = new ArrayList<>();
        List<Rest> expectedRest = new ArrayList<>();
        List<StairIntervalTrainingWorkout> expectedStairInterval = new ArrayList<>();
        List<CrossTrainingWorkout> expectedCrossTrainingWorkouts = new ArrayList<>();
        List<StrengthCircuitWorkout> expectedStrengthWorkouts = new ArrayList<>();

        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy",1,1));
        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,2));
        expectedHike.add(new HikeWorkout("hike", "30min", "medium", 1, 2));
        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,3));
        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,4));
        expectedHike.add(new HikeWorkout("hike", "30min", "medium", 1, 4));
        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 1,5));
        expectedHike.add(new HikeWorkout("hike", "30min", "medium", 1, 6));
        expectedRest.add(new Rest(1,7));
        expectedStairInterval.add(new StairIntervalTrainingWorkout("stair interval", "30min", "medium",2,1));
        expectedCrossTrainingWorkouts.add(new CrossTrainingWorkout("cross training", "1hr", "hard", 2,2));
        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 2,3));
        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 2,4));
        expectedRest.add(new Rest(2,4));
        expectedRD.add(new RainierDozenWorkout("rainier dozen", "12min", "easy", 2,5));
        expectedHike.add(new HikeWorkout("hike", "30min", "medium", 2, 6));
        expectedStrengthWorkouts.add(new StrengthCircuitWorkout("strength circuit", "1hr", "medium",2,7));


        Assert.assertEquals(expectedRD, actual.getRainierDozenWorkouts());
        Assert.assertEquals(expectedHike, actual.getHikeWorkouts());
        Assert.assertEquals(expectedRest, actual.getRests());
        Assert.assertEquals(expectedCrossTrainingWorkouts, actual.getCrossTrainingWorkouts());
        Assert.assertEquals(expectedStairInterval, actual.getStairIntervalWorkouts());
        Assert.assertEquals(expectedStrengthWorkouts, actual.getStrengthCircuitWorkouts());
    }
}
