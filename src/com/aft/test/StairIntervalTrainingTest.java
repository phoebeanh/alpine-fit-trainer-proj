package com.aft.test;

import com.aft.workouts.StairIntervalTraining;
import org.junit.Assert;
import org.junit.Test;

public class StairIntervalTrainingTest {

    StairIntervalTraining actual = new StairIntervalTraining("1hr", "Medium", "High-Intensity");

    @Test
    public void getIntensityIfSpecified() {
        Assert.assertEquals("High-Intensity", actual.getIntensity());
    }

    @Test
    public void getIntensityIfUnspecified() {
        actual = new StairIntervalTraining("1hr", "Medium");
        Assert.assertEquals("Normal Intensity", actual.getIntensity());
    }
}