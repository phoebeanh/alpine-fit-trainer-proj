package com.aft.test;

import com.aft.main.workouts.StairIntervalTrainingWorkout;
import org.junit.Assert;
import org.junit.Test;

public class StairIntervalTrainingWorkoutTest {

    StairIntervalTrainingWorkout actual = new StairIntervalTrainingWorkout("1hr", "Medium", 1,1,"High-Intensity");

    @Test
    public void getIntensityIfSpecified() {
        Assert.assertEquals("High-Intensity", actual.getIntensity());
    }

    @Test
    public void getIntensityIfUnspecified() {
        actual = new StairIntervalTrainingWorkout("1hr", "Medium",1,1);
        Assert.assertEquals("Normal Intensity", actual.getIntensity());
    }
}