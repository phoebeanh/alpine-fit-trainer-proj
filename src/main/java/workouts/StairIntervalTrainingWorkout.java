package workouts;

/**
 * This exercise specifies stair climbing training
 */
public class StairIntervalTrainingWorkout extends Workout{
    private String intensity = "Normal Intensity";
    private String name =  "Stair Interval";

    public StairIntervalTrainingWorkout(String name, String duration, String difficulty, int week, int day) {
        super(name, duration, difficulty, week, day);
    }

    public StairIntervalTrainingWorkout(String name, String duration, String difficulty, int week, int day, String intensity) {
        super(name, duration, difficulty, week, day);
        this.intensity = intensity;
    }

    public String getName() {
        return this.name;
    }

    public String getIntensity() {
        return this.intensity;
    }

}
