package workouts;

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
}
