package workouts;

public class Rest extends Workout {
    private String name = "Rest";
    public Rest(int week, int day) {
        super("Rest", "N/A", "N/A", week, day);
    }
    public Rest(String name, String duration, String difficulty, int week, int day) {
        super(name, duration, difficulty, week, day);
    }

}
