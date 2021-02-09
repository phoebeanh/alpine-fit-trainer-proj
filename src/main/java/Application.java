import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Alpine Fit Trainer. \n" +
                "Enter the file name of the default workouts: (hint: type default.csv)");
        Scanner userInput = new Scanner(System.in);
        try {
            String file = userInput.nextLine();

            DefaultWorkout defaultWorkout = new DefaultWorkout(file);
            ScheduleFormatter formatter = new ScheduleFormatter(defaultWorkout.getAllWorkouts());

            while (true) {
                System.out.println("--------------MAIN MENU---------------\n" +
                        "Please choose one of the following options:\n" +
                        "1. Edit schedule | 2. Display training week schedule | 3. Display full training schedule | " +
                        "4. Export full schedule to XLSX | 5. Close");
                    int answer = Integer.parseInt(userInput.nextLine());
                    switch (answer){
                        case 1:
                            System.out.println("TODO");
                            break;
                        case 2:
                            System.out.println("Week to display (1-16): ");
                            int week = Integer.parseInt(userInput.nextLine());
                            if (week >= 1 && week <= 16)
                                formatter.printFormattedWorkoutsForWeek(week);
                            else
                                System.out.println("Invalid week number!");
                            break;
                        case 3:
                            formatter.printAllFormattedWorkouts();
                            break;
                        case 4:
                            System.out.println("Printing current schedule to file " + "NOT IMPLEMENTED YET"); //TODO
                            break;
                        case 5:
                            System.out.println("Goodbye!");
                            userInput.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid selection!");
                            break;
                    }
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid user entry");
        } finally {
            userInput.close();
        }
    }
}
