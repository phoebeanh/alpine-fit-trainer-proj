package error;

public class IllFormedWorkoutException extends Exception {
    public IllFormedWorkoutException() {
        super("Workout does not match correct syntax");
    }
    public IllFormedWorkoutException(String e) {
        super(e);
    }

    public String getMessage(){
        return ("IllFormedWorkout Occurred: Workout does not match correct syntax") ;
    }
}
