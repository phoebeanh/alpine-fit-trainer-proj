## CS622 - Spring 1 - Phoebe Ngo

### Introduction
This project aims to create a platform for aspiring mountaineers to keep track of and plan their fitness training schedule. The guidelines and objectives of the fitness training program will be loosely based on the information in Fit to Climb: A 16-Week Mount Rainier Fitness Training Program, by John Colver. To use the platform, a user would input when their climb is scheduled; to fully utilize the platform’s features, the user must not input a date any sooner than four months from the current date. Once that condition has been cleared, the platform will provide a calendar populated with a daily training objective. There are different types of workouts that will be used over the course of the program: Rainier Dozen, Hikes, Stair Interval Training, Strength Circuit Training, and Cross Training. These workouts can vary in lengths of time and intensity. The focus of the project is to create a visual dashboard that shows what training objective the user must meet daily, what type of training it is, and its duration and intensity, if applicable, to meet their fitness goals before their summit attempt. This platform will be called Alpine Fit Trainer.

### To Run Program
- Navigate to project root folder
- Run the command `./mvnw clean package`
- Navigate to folder with newly created .jar file
- Run .jar file

### To Run Tests
- From the project root folder, run the command `./mvnw test`

### Functional Requirements

#### 1.3.1 Create Workout Types 
AFT shall accept CrossTraining, Hike, RainierDozen, StairInterval, and StrengthCircuit workouts. 
#### 1.3.2 Report Weekly Training Schedule 
AFT shall report all workout objectives for a week of training to the console.
#### 2.3.1 Default Schedule Specifications: Order
The input for the workout schedule comes from a file. Each line in the file represents one workout. However, there may be some days with multiple workouts.
#### 2.3.1.a Default Schedule Specifications: Change Workout Schema
Since some days may offer multiple workouts, the week and day of the exercise must be noted in the creation of the workout object. Thus, we must add a ‘week’ and ‘day’ variables to our workout objects, as integer values.
#### 2.3.2 Default Schedule Specifications: Workout Instantiation
Each line in the input file defines a well-formed workout object as its variables in this order: Name, Duration, Difficulty, Week and Day, separated by commas. 
Some workouts, depending on name, will have additional variables. 
These are listed below:
- CrossTrainingWorkout: Activity
- HikeWorkout: PackWeight, Mileage
- StairIntervalWorkout: Intensity
#### 2.3.3 Workout Information Input I/O
A well-formed workout object will contain its name as the first in the comma separated line containing that workout’s information, followed by duration and difficulty. 
Additional parameters will follow in that same line. The program will take this input as a line in a text file. 
#### 2.3.4 Save Workout Objects by Week
The program will print a report of the saved workouts.
#### 2.3.5 Print Full Workout to User
The program gives the user a completed view of their schedule based on the file given.
#### 3.2.1 Display all current workouts to user
When a user prompts the program to show them their current training schedule, the program will show all documented exercises in ascending order from Week 1, Day 1’s workouts, to Week 16, Day 7’s workouts.
#### 3.2.2 Display all workouts for user-specified week
The program can give the user the training schedule for any particular week.
#### 3.2.3 Give User Options to Interact with Their Schedule
The user’s main interaction with the program will now involve a menu interface. Depending on their input, the user can choose to edit their schedule, display a specific week’s schedule, display the full schedule, export their schedule to a file, or exit the program.
####4.2.1 Export Workout Schedule to CSV File
The application will export a user’s workout schedule to a .CSV file into their current directory. The name of the file will be based on the timestamp of its creation, to not create duplicates.