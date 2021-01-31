package com.aft.workouts;

/**
 *  base class of workouts
 */
public abstract class Workout {
    private String duration;
    private String difficulty;

    public Workout(String duration, String difficulty) {
        this.setDuration(duration);
        this.setDifficulty(difficulty);
    }

    public abstract String getName();
    public String getDuration() { return this.duration; }
    public String getDifficulty() { return this.difficulty; }

    public void setDuration(String duration) { this.duration = duration; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
}
