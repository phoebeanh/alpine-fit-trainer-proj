import workouts.Workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The schedule formatter takes in a list of workouts of any kind. It can return an array list of "sorted" workouts
 * (ie. a list containing workouts in order of the program schedule: workouts for week 1, day 1,
 * will come first in the list, followed by week 1, day 2, then week 1, day 3, etc.
 * It can also print out the list of sorted workouts to the user's console.
 * Users can format a schedule by a specific week
 */
public class ScheduleFormatter implements Serializable {
    private List<Workout> workouts;

    public ScheduleFormatter(List<Workout> Workouts) {
        this.workouts = Workouts;
    }

    public ArrayList<? extends Workout> getWorkoutsForWeek(int week) {
        /**
         * Preconditions: ScheduleFormatter was created with valid workouts and contains multiple types of workouts
         * Preconditions2: The user-inputted week is a valid week (ie. less than 16)
         * Postconditions: Returns a list of workouts that are ordered by day for a specific week
         */
        int day = 1;
        List<Workout> workoutsForWeek = new ArrayList<>();

        while(day <=7) {
            for (Workout workout : workouts) {
                if (workout.getWeek() == week && workout.getDay() == day) {
                    workoutsForWeek.add(workout);
                }
                // reaches end of workouts list, retries search through list to find next days' workouts in same week
                if (workouts.indexOf(workout) == getEndIndex())
                    day++;
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
                else if (workouts.indexOf(workout) == getEndIndex() && week <= 16)
                    day++;
            }
        }
        return new ArrayList<>(formatted);
    }

    /**
     * Precondition: Workouts are valid
     * Postcondition: Display each workout and its variables in order of date for the entire workout program
     */
    public void printAllFormattedWorkouts() {
        ArrayList<? extends Workout> formatted = getFormattedWorkouts();
        formatted.forEach((workout -> System.out.println(workout + "\n")));
    }

    /**
     * Precondition: Week is defined in the existing schedule, otherwise, will return a blank line
     * Postcondition: Display each workout and its variables in order of date for a given week
     * @param week
     */
    public void printFormattedWorkoutsForWeek(int week) {
        ArrayList<? extends Workout> formatted = getWorkoutsForWeek(week);
        formatted.forEach((workout -> System.out.println(workout + "\n")));
    }

    /**
     *
     * @param workout
     * Adds a new workout to the existing schedule
     * @return a formatted array list of the schedule's workouts, now including the new one
     */
    public ArrayList<? extends Workout> addWorkout(Workout workout) {
        this.workouts.add(workout);
        return getFormattedWorkouts();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<? extends Workout> formatted = getFormattedWorkouts();
        formatted.forEach((workout) -> sb.append(workout.toString() + "\n\n"));
        return sb.toString();
    }

    public ArrayList<? extends Workout> getWorkoutsForDay(int week, int day) {
        return (ArrayList<? extends Workout>) this.workouts.stream().filter((workout) ->
                workout.getWeek() == week && workout.getDay() == day).collect(Collectors.toList());
    }

    public void removeWorkoutsFromDay(ArrayList<? extends Workout> workoutsForDay) {
        this.workouts = this.workouts.stream().filter(
                (workout) -> !workoutsForDay.contains(workout)).collect(Collectors.toList());
    }

    public void deleteWorkout(Workout workout) {
        if (this.workouts.contains(workout))
            removeWorkoutsFromDay(new ArrayList<>(Arrays.asList(workout)));
        else
            System.err.println("Workout does not exist in schedule.");
    }

    private int getEndIndex() {
        return this.workouts.size() - 1;
    }
}
