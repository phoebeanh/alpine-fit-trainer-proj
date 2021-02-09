package workouts;

/**
 * Rest is used during specific days of the week of the program to allow the user's body to recover and prevent injury.
 * Doing some simple yoga or stretching can be done during these training days.
 */
public class Rest extends Workout {
    private String name = "Rest";
    public Rest(int week, int day) {
        super("Rest", "N/A", "N/A", week, day);
    }
    public Rest(String name, String duration, String difficulty, int week, int day) {
        super(name, duration, difficulty, week, day);
    }

}
