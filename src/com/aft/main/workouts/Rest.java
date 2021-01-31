package com.aft.main.workouts;

public class Rest extends Workout {
    public Rest(String duration, String difficulty, int week, int day) {
        super(duration, difficulty, week, day);
    }

    @Override
    public String getName() {
        return "Rest";
    }
}
