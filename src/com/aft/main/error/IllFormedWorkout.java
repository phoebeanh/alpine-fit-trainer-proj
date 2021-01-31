package com.aft.main.error;

public class IllFormedWorkout extends Exception {
    private String err;

    public  IllFormedWorkout() {
        err = "Workout does not match correct syntax";
    }

    public IllFormedWorkout(String e) {
        err = e;
    }

    @Override
    public String toString(){
        return ("IllFormedWorkout Occurred: "+ err) ;
    }
}
