import workouts.Workout;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Alpine Fit Trainer. \n" +
                "Enter the file name of the default workouts: (hint: type default.csv)");
        Scanner userInput = new Scanner(System.in);
        String file = userInput.nextLine();

        DefaultWorkout defaultWorkout = new DefaultWorkout(file);

        System.out.println("Your current schedule is: (currently out of order)");
        for (Workout workout : defaultWorkout.getWorkouts()) {
            System.out.println(workout);
        }
    }
}
