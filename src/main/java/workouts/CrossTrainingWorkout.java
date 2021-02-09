package workouts;

/**
 * The cross training workout is used for the user to stay active with some moderate exercise, engage different
 * muscles that they may use at other points in the week, and can be used to explore a new sport or physical activity,
 * such as rock climbing, yoga, or a game of soccer.
 */
public class CrossTrainingWorkout extends Workout {
    private String activity = "any";

    public CrossTrainingWorkout(String name, String duration, String difficulty, int week, int day) {
        super(name, duration, difficulty, week, day);
    }

    public CrossTrainingWorkout(String name, String duration, String difficulty, int week, int day, String activity) {
        super(name, duration, difficulty, week, day);
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Activity: " + this.activity;
    }
}
