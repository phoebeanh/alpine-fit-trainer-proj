package com.aft.main.workouts;

/**
 *  base class of workouts
 */
public abstract class Workout {
    private String duration;
    private String difficulty;
    private int week;
    private int day;

    public Workout(String duration, String difficulty, int week, int day) {
        this.setDuration(duration);
        this.setDifficulty(difficulty);
        this.setWeek(week);
        this.setDay(day);
    }

    public abstract String getName();
    public String getDuration() { return this.duration; }
    public String getDifficulty() { return this.difficulty; }
    public int getWeek() { return week; }
    public int getDay() { return day; }

    public void setDuration(String duration) { this.duration = duration; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setWeek(int week) { this.week = week; }
    public void setDay(int day) { this.day = day; }
}
