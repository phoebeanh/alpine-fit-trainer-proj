
import workouts.*;
import error.IllFormedWorkout;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultWorkout {

    private List<CrossTrainingWorkout> crossTrainingWorkouts = new ArrayList<>();
    private List<HikeWorkout> hikeWorkouts = new ArrayList<>();
    private List<RainierDozenWorkout> rainierDozenWorkouts = new ArrayList<>();
    private List<StairIntervalTrainingWorkout> stairIntervalWorkouts = new ArrayList<>();
    private List<StrengthCircuitWorkout> strengthCircuitWorkouts = new ArrayList<>();
    private List<Rest> rests = new ArrayList<>();

    public DefaultWorkout(String path) {
        // Precond: A file with valid workout information must exist
        // Postcond: The default workout values will be stored in a List of Workouts as a variable to
        // the DefaultWorkout class.
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            // iterate through workout
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                getWorkouts(line);
            }
        } catch (IllFormedWorkout illFormedWorkout) {
            illFormedWorkout.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getWorkouts(String workout) throws IllFormedWorkout {
        /**
         * Precondition: valid file and well-formed lines in file
         * Postcondition: creates internal lists of each type of workout in the file: these are found by iterating
         * through each line of the file and determining what the length of the line is to use the right constructor
         */

        String[] line = workout.trim().split(",");
        String name = line[0].toLowerCase();
        try {
            if (line.length == 5) {
                if (name.equals("cross training"))
                    crossTrainingWorkouts.add(new CrossTrainingWorkout(name,line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                else if (name.equals("hike"))
                    hikeWorkouts.add(new HikeWorkout(name, line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                else if (name.equals("rainier dozen"))
                    rainierDozenWorkouts.add(new RainierDozenWorkout(name, line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                else if (name.equals("stair interval"))
                    stairIntervalWorkouts.add(new StairIntervalTrainingWorkout(name, line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                else if (name.equals("strength circuit"))
                    strengthCircuitWorkouts.add(new StrengthCircuitWorkout(name, line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4])));
                else if (name.equals("rest"))
                    rests.add(new Rest(Integer.parseInt(line[3]), Integer.parseInt(line[4])));
            } else if (line.length > 5) {
                if (name.equals("cross training"))
                    crossTrainingWorkouts.add(new CrossTrainingWorkout(name, line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]), line[5]));
                else if (name.equals("hike"))
                    hikeWorkouts.add(new HikeWorkout(name, line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]), line[5], Integer.parseInt(line[6])));
                else if (name.equals("stair interval"))
                    stairIntervalWorkouts.add(new StairIntervalTrainingWorkout(name, line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]), line[5]));
            } else
                throw new IllFormedWorkout();
        } catch(IllFormedWorkout e) { System.out.println("Error parsing file at line: " + workout); }

}

    public List<CrossTrainingWorkout> getCrossTrainingWorkouts() {
        return crossTrainingWorkouts;
    }

    public List<HikeWorkout> getHikeWorkouts() {
        return hikeWorkouts;
    }

    public List<RainierDozenWorkout> getRainierDozenWorkouts() {
        return rainierDozenWorkouts;
    }

    public List<StairIntervalTrainingWorkout> getStairIntervalWorkouts() {
        return stairIntervalWorkouts;
    }

    public List<StrengthCircuitWorkout> getStrengthCircuitWorkouts() {
        return strengthCircuitWorkouts;
    }

    public List<Rest> getRests() {
        return rests;
    }
}