package workouts;

/**
 *  base class of workouts
 */
public abstract class Workout {
    private String name;
    private String duration;
    private String difficulty;
    private int week;
    private int day;

    public Workout(String name, String duration, String difficulty, int week, int day) {
        this.setName(name);
        this.setDuration(duration);
        this.setDifficulty(difficulty);
        this.setWeek(week);
        this.setDay(day);
    }

    public String getName() { return this.name; }
    public String getDuration() { return this.duration; }
    public String getDifficulty() { return this.difficulty; }
    public int getWeek() { return week; }
    public int getDay() { return day; }

    public void setName(String name) { this.name = name; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setWeek(int week) { this.week = week; }
    public void setDay(int day) { this.day = day; }

    @Override
    public String toString() {
        return "Workout: " + name + ", Duration: " + duration + ", Difficulty: " + difficulty +
                ", Week: " + week + ", Day: " + day;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Workout) {
            Workout workout = (Workout) object;
            if (workout.getName().equals(this.getName()) &&
                    workout.getDifficulty().equals(this.getDifficulty()) &&
                    workout.getDuration().equals(this.getDuration()) &&
                    workout.getWeek() == this.getWeek() &&
                    workout.getDay() == this.getDay())
                return true;
            else
                return false;
        } else
            return false;
    }
}
