package com.aft.main;

import com.aft.main.error.IllFormedWorkout;
import com.aft.main.workouts.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultWorkout {

    private List<Workout> defaultWorkout = new ArrayList<>();

    public DefaultWorkout(String path) {
        // Precond: A file with valid workout information must exist
        // Postcond: The default workout values will be stored in a List of Workouts as a variable to
        // the DefaultWorkout class.
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            // iterate through workout
            while (scanner.hasNext()) {
                defaultWorkout.add(getWorkout(scanner.nextLine()));
            }
        } catch (IllFormedWorkout illFormedWorkout) {
            illFormedWorkout.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private Workout getWorkout(String workout) throws IllFormedWorkout {
        String[] line = workout.split(",");
        Workout newWorkout = null;
        switch(line[0].toLowerCase()) {
            case "cross training":
                if (line.length == 5)
                    newWorkout = new CrossTrainingWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]));
                else if (line.length == 6)
                    newWorkout =new StairIntervalTrainingWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]), line[5]);
                break;
            case "hike":
                if (line.length == 5)
                    newWorkout = new HikeWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]));
                else if (line.length == 7)
                    newWorkout = new HikeWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]), line[5], Integer.getInteger(line[6]));
                break;
            case "rainier dozen":
                newWorkout = new RainierDozenWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]));
                break;
            case "stair interval":
                if (line.length == 5)
                    newWorkout =new StairIntervalTrainingWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]));
                else if (line.length == 6)
                    newWorkout =new StairIntervalTrainingWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]), line[5]);
                break;
            case "strength circuit":
                if (line.length == 5)
                    newWorkout =new StrengthCircuitWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]));
                else if(line.length == 6)
                    newWorkout =new StairIntervalTrainingWorkout(line[1], line[2], Integer.getInteger(line[3]), Integer.getInteger(line[4]), line[5]);
                break;
            default:
                throw new IllFormedWorkout();
        }
        return newWorkout;
    }

    public List<Workout> getDefaultWorkouts() {
        return defaultWorkout;
    }
}
