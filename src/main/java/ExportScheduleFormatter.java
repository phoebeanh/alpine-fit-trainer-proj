import workouts.Workout;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExportScheduleFormatter {
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String DOUBLE_QUOTES = "\"";
    private static final String EMBEDDED_DOUBLE_QUOTES = "\"\"";
    private static final String NEW_LINE_UNIX = "\n";
    private static final String NEW_LINE_WINDOWS = "\r\n";
    private ScheduleFormatter formatter;
    private String currentFilePath = "";

    public ExportScheduleFormatter(ScheduleFormatter formatter) {
        this.formatter = formatter;
    }

    /**
     *
     * Postcondition: CSV file containing all workouts should be created
     * Postcondition2: each row should contain a different workout, in ascending order of week and day implemented
     * Postcondition3: The headers should read: "Workout Name", "Duration", "Difficulty", "Week", "Day", and "Other Information"
     */
    public void writeWorkoutsToFile() {
        try {
            setCurrentFilePath("all");
            String filepath = this.getCurrentFilePath();
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            List<String[]> csvLines = buildCSVLines(formatter.getFormattedWorkouts());

            List<String> collect = csvLines.stream()
                    .map(this::convertToCSV)
                    .collect(Collectors.toList());

            for (String line : collect) {
                objectOut.writeUTF(line + "\n\n");
            }
            objectOut.close();
            fileOut.close();
            System.out.printf("Your schedule was successfully written to %s\n", filepath);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setCurrentFilePath(String type) {
        this.currentFilePath = String.format("schedule-%s-%s.csv",type,Instant.now().getEpochSecond());
    }

    public String getCurrentFilePath() {
        return this.currentFilePath;
    }

    private List<String[]> buildCSVLines(ArrayList<? extends Workout> workouts) {
        List<String[]> lines = new ArrayList<>();
        // adds headers
        lines.add(new String[]{"Workout Name", "Duration", "Difficulty", "Week", "Day", "Other Information"});
        // adds each workout to string array in list
        workouts.forEach(workout -> lines.add(workout.toStringArray()));
        return lines;
    }

    /**
     * Encloses each field of a workout in double quotes
     * @param workout
     * @return
     */
    private String convertToCSV(String[] workout) {
        return Stream.of(workout)                                // convert Workout to stream
                .map(w -> formatCSVWorkout(w))                  // format CSV field
                .collect(Collectors.joining(DEFAULT_SEPARATOR));    // join with a separator
    }

    /**
     * Removes values in the string field that might mess with the formatting syntax of the CSV file
     * @param field
     * @return
     */
    private String formatCSVWorkout(String field) {
        String result = field;

        if (result.contains(DEFAULT_SEPARATOR)
                || result.contains(DOUBLE_QUOTES)
                || result.contains(NEW_LINE_UNIX)
                || result.contains(NEW_LINE_WINDOWS)) {

            result = result.replace(DOUBLE_QUOTES, EMBEDDED_DOUBLE_QUOTES);

            result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;
        }

        return result;
    }

    /**
     * Precondition: User selects option to export separate files of each week of their workout schedule
     * Postcondition: Multiple CSV files, each containing a separate week of workouts, should be created
     * Postcondition2: each row should contain a different workout, in ascending order of day implemented
     * Postcondition3: The headers should read: "Workout Name", "Duration", "Difficulty", "Week", "Day", and "Other Information"
     */
    public void writeWorkoutsToSeparateFiles() {
        for (int week = 1; week <= 16; week++) {
            ArrayList<? extends Workout> workoutsForWeek = formatter.getWorkoutsForWeek(week);
            // if there exists any workouts for this week, will create thread to make file
            if (!workoutsForWeek.isEmpty()) {
                ScheduleThread scheduleThread = new ScheduleThread(week, workoutsForWeek);
                Thread weekThread = new Thread(scheduleThread);
                weekThread.start();
            }
        }
    }

    /**
     * ScheduleThread is an inner runnable class that will export each week of workout schedules to a separate CSV file.
     */
    private class ScheduleThread implements Runnable {

        private int week;
        private ArrayList<? extends Workout> workouts;

        public ScheduleThread(int week, ArrayList<? extends Workout> workouts) {
            this.week = week;
            this.workouts = workouts;
        }

        @Override
        public void run() {
            // Postcondition 1: Each week of workouts is printed to separate file
            try {
                String filepath = String.format("schedule-%s-%s.csv",this.week,Instant.now().getEpochSecond());
                FileOutputStream fileOut = new FileOutputStream(filepath);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

                List<String[]> csvLines = buildCSVLines(this.workouts);

                List<String> collect = csvLines.stream()
                        .map(ExportScheduleFormatter.this::convertToCSV)
                        .collect(Collectors.toList());

                for (String line : collect) {
                    objectOut.writeUTF(line + "\n\n");
                }
                objectOut.close();
                fileOut.close();
                System.out.printf("Your schedule was successfully written to %s\n", filepath);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
