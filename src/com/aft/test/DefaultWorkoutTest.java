package com.aft.test;

import com.aft.main.DefaultWorkout;
import com.aft.main.workouts.HikeWorkout;
import com.aft.main.workouts.RainierDozenWorkout;
import com.aft.main.workouts.Rest;
import com.aft.main.workouts.Workout;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DefaultWorkoutTest {

    private Path workingDir;

    @Before
    public void setUp() {
        // Precond: set up relative path to test data
        this.workingDir = Paths.get("", "src/com/aft/test/resources");
    }

    @Test
    public void ValidIntakeDefaultWorkoutTest() {
        DefaultWorkout actual = new DefaultWorkout(workingDir.resolve("default.csv").toString());
        ArrayList<Workout> week1 = new ArrayList<>();
        List<ArrayList<Workout>> expected = new ArrayList<>();
        week1.add(new RainierDozenWorkout("12min", "easy",1,1));
        week1.add(new RainierDozenWorkout("12min", "easy", 1,2));
        week1.add(new HikeWorkout("30min", "medium",1,2));
        week1.add(new RainierDozenWorkout("12min", "easy", 1,3));
        week1.add(new RainierDozenWorkout("12min", "easy", 1,4));
        week1.add(new HikeWorkout("30min", "medium", 1,4));
        week1.add(new RainierDozenWorkout("12min", "easy", 1,5));
        week1.add(new HikeWorkout("30min", "easy", 1,6));
        week1.add(new Rest("","",1,7));

        Assert.assertEquals(expected, actual.getDefaultWorkouts());
    }
}
