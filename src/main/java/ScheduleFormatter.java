import workouts.Workout;

import java.util.ArrayList;
import java.util.List;

/**
 * The schedule formatter takes in a list of workouts of any kind. It can return an array list of "sorted" workouts
 * (ie. a list containing workouts in order of the program schedule: workouts for week 1, day 1,
 * will come first in the list, followed by week 1, day 2, then week 1, day 3, etc.
 * It can also print out the list of sorted workouts to the user's console.
 * Users can format a schedule by a specific week
 */
public class ScheduleFormatter {
    private List<? extends Workout> workouts;
    private int endIndex;

    public ScheduleFormatter(List<? extends Workout> Workouts) {
        this.workouts = Workouts;
        this.endIndex = Workouts.size()-1;
    }

    public ArrayList<? extends Workout> getWorkoutsForWeek(int week) {
        int day = 1;
        List<Workout> workoutsForWeek = new ArrayList<>();

        while(day <=7) { //TODO bug
            for (Workout workout : workouts) {
                if (workout.getWeek() == week && workout.getDay() == day) {
                    workoutsForWeek.add(workout);
                    day++;
                }
            }
        }
        return new ArrayList<>(workoutsForWeek);
    }

    public ArrayList<? extends Workout> getFormattedWorkouts() {
        /**
         * Preconditions: ScheduleFormatter was created with valid workouts and contains multiple types of workouts
         * Preconditions2: The maximum amount of weeks of a schedule is 16
         * Postconditions: Returns a list of workouts that are ordered by week and day that they are scheduled as.
         */
        int week = 1;
        int day = 1;
        List<Workout> formatted = new ArrayList<>();
        //iterates through all workouts until all possible workouts in list for each day of program are calculated
        while (week != 17) {
            for (Workout workout : workouts) {
                if (workout.getWeek() == week && workout.getDay() == day) {
                    formatted.add(workout);
                }
                // reaches end of workouts, has finished finding all workouts for that week, moves on to next week
                if(day > 7) {
                    day = 1;
                    week++;
                }
                // reaches end of workouts list, retries search through list to find next days' workouts in same week
                else if (workouts.indexOf(workout) == endIndex && week <= 16)
                    day++;
            }
        }
        return new ArrayList<>(formatted);
    }

    public void printAllFormattedWorkouts() {
        ArrayList<? extends Workout> formatted = getFormattedWorkouts();
        for (Workout workout : formatted) {
            System.out.println(workout);
        }
    }

    public void printFormattedWorkoutsForWeek(int week) {
        ArrayList<? extends Workout> formatted = getWorkoutsForWeek(week);
        for (Workout workout : formatted) {
            System.out.println(workout);
        }
    }

}
