import error.IllFormedWorkoutException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workouts.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExportScheduleFormatterTest {
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

    /**
     * Precondition: workouts in schedule are formatted correctly
     * Precondition: There exists some array of workouts
     * Precondition: A valid ScheduleFormatter is created
     * Postcondition: Assert that a file of an expected name is created in the output directory
     */
    @Test
    void writeWorkoutsToFile() {
        ScheduleFormatter scheduleFormatter = new ScheduleFormatter(testWorkouts);
        ExportScheduleFormatter actual = new ExportScheduleFormatter(scheduleFormatter);

        actual.writeWorkoutsToFile();
        String expectedFilePath = actual.getCurrentFilePath();
        File createdFile = new File(expectedFilePath);

        Assert.assertTrue(createdFile.exists());

        //delete file upon completion of test to avoid clutter in directory
        createdFile.delete();
    }

    /**
     * Precondition: workouts in schedule are formatted correctly
     * Precondition: There exists some array of workouts
     * Precondition: A valid ScheduleFormatter is created
     * Postcondition: Assert that two files created in the output directory that contain workout schedules
     * for week 1 and 2 of program
     * Postcondition: Delete files after test completion
     */
    @Test
    void writeWorkoutsToTwoSeparateFiles() throws InterruptedException {
        ScheduleFormatter scheduleFormatter = new ScheduleFormatter(testWorkouts);
        ExportScheduleFormatter actual = new ExportScheduleFormatter(scheduleFormatter);

        actual.writeWorkoutsToSeparateFiles();
        File directory = new File(System.getProperty("user.dir"));

        // allow time for files to finish writing
        Thread.sleep(2000);

        // find count of .CSV in the directory; for this test it should be 2
        long count =
                Arrays.stream(directory.list())
                .filter((filename) -> {
                            File temp = new File(directory, filename);
                            if (temp.getPath().endsWith(".csv")) {
                                //delete files once confirmed to exist to avoid clutter in directory
                                temp.delete();
                                return true;
                            }
                            return false;
                        }).count();

        // assert there are two csv files in directory
        Assert.assertTrue(count == 2);
    }
}