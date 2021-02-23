import workouts.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EditWorkout {
    private ScheduleFormatter formatter;

    public EditWorkout(ScheduleFormatter formatter) {
        this.formatter = formatter;
    }

    public ScheduleFormatter start() {
        Scanner userInput = new Scanner(System.in);
        boolean finished = false;

            while (!finished) {
                System.out.println("--------------EDIT SCHEDULE---------------\n" +
                        "Enter the week and day of which you wish to edit the schedule of.\n" +
                        "The format should be \'WEEK DAY\', with both inputs being integers " +
                        "and a space between them, for example, to edit week 1, day 1's schedule,\n" +
                        "you would enter \'1 1\'. \nTo exit back to the main menu, enter 0.");

                //convert answer to integer array
                String user = userInput.nextLine();

                if (user.equals("0")) {
                    finished = true;
                } else {
                    int[] answer = Arrays.stream(user.split(" ")).mapToInt(Integer::parseInt).toArray();
                    int week = answer[0];
                    int day = answer[1];
                        ArrayList<? extends Workout> workoutsForDay = this.formatter.getWorkoutsForDay(week, day);
                        System.out.printf("Selected: Week %s, Day %s\n", week, day);
                        System.out.printf("Current schedule for this day is: %s\n", workoutsForDay);
                        System.out.println("-------------------OPTIONS-------------------\n" +
                                "Please choose one of the following options:\n" +
                                "1. Edit existing workouts | 2. Convert to rest day | 3. Back");
                        int input = Integer.parseInt(userInput.nextLine());
                        switch (input) {
                            case 1:
                                editWorkouts(workoutsForDay, week, day);
                                break;
                            case 2:
                                this.formatter.removeWorkoutsFromDay(workoutsForDay);
                                this.formatter.addWorkout(new Rest(week, day));
                                System.out.printf("Deleted current workout(s) for Week %s, Day %s. Work day is now a rest day.", week, day);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid entry!");
                                break;
                        }
                }
            }
        // return to main menu with new formatted schedule
        return this.formatter;
    }

    private void editWorkouts(ArrayList<? extends Workout> workoutsForDay, int week, int day) {
        Scanner scanner = new Scanner(System.in);

        for (Workout workout : workoutsForDay) {
            System.out.printf("Would you like to delete this %s workout?\nEnter Y/N", workout.getName());
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("y")) {
                this.formatter.deleteWorkout(workout);
            } else if (userInput.equalsIgnoreCase("n")) {
                continue;
            } else {
                System.out.println("Invalid entry! Skipping...");
                continue;
            }
        }

        System.out.println("Would you like to add new workout?\nEnter Y/N");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("y")) {
            while (true) {
                System.out.println("-------------------OPTIONS-------------------\n" +
                        "Please choose one of the following options:\n" +
                        "1. Add cross-training workout | 2. Add hike workout | 3. Add Rainier Dozen workout" +
                        "4. Add stair interval workout | 5. Add strength circuit workout | 6. Exit");
                int input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        System.out.println("Specify your cross-training activity, for example: soccer, running," +
                                "rock climbing, etc.");
                        userInput = scanner.nextLine();
                        this.formatter.addWorkout(new CrossTrainingWorkout
                                ("cross training", "40-min", "medium", week, day, userInput));
                        break;
                    case 2:
                        System.out.println("Specify your hike duration, for example: 1hr, 30min, etc.");
                        String duration = scanner.nextLine();

                        System.out.println("Specify your hike difficulty, for example: easy, medium, hard.");
                        String difficulty = scanner.nextLine();

                        System.out.println("Specify your hike pack weight, for example: none, 10lb, 50lb.");
                        String packWeight = scanner.nextLine();

                        System.out.println("Specify your hike mileage, for example: 1, 5.8. 10, etc.");
                        String mileage = scanner.nextLine();

                        this.formatter.addWorkout(new HikeWorkout
                                ("hike", duration, difficulty, week, day, packWeight, Double.parseDouble(mileage)));
                        break;
                    case 3:
                        this.formatter.addWorkout(new RainierDozenWorkout
                                ("rainier dozen", "12 min", "easy", week, day));
                        break;
                    case 4:
                        System.out.println("Specify your stair interval duration, for example: 1hr, 30min, etc.");
                        duration = scanner.nextLine();

                        System.out.println("Specify your stair interval difficulty, for example: easy, medium, hard.");
                        difficulty = scanner.nextLine();

                        System.out.println("Specify your stair interval intensity, for example: easy, hard");
                        String intensity = scanner.nextLine();

                        this.formatter.addWorkout(new StairIntervalTrainingWorkout
                                ("stair interval", duration, difficulty, week, day, intensity));
                        break;
                    case 5:
                        System.out.println("Specify your strength circuit duration, for example: 1hr, 30min, etc.");
                        duration = scanner.nextLine();

                        System.out.println("Specify your strength circuit difficulty, for example: easy, medium, hard.");
                        difficulty = scanner.nextLine();

                        System.out.println("Add any additional exercises (Example input: \'frog squats, bicep curls, burpees\'");
                        String[] exercises = scanner.nextLine().split(", ");

                        StrengthCircuitWorkout workout = new StrengthCircuitWorkout
                                ("stair interval", duration, difficulty, week, day);
                        for (String exercise : exercises)
                            workout.addExercise(exercise);

                        this.formatter.addWorkout(workout);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid entry!");
                        break;
                }
            }
        } else if (userInput.equalsIgnoreCase("n")) {
            return;
        } else {
            System.out.println("Invalid entry!");
        }
    }
}
